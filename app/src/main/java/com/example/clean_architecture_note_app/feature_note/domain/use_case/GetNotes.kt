package com.example.clean_architecture_note_app.feature_note.domain.use_case

import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.repository.NoteRepository
import com.example.clean_architecture_note_app.feature_note.domain.util.NoteOrder
import com.example.clean_architecture_note_app.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNotes @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<NoteModel>>{
        // вызвращаем результат в зависимости от требуемых пораметров, через map проходимся через все записи
        return repository.getNotes().map {notes->
            // применяем первый способ фильрации, по возростанию или убыванию
            when(noteOrder.orderType){
                // если по возростанию
                is OrderType.Ascending->{
                    // применяем следующий фильтер, отсортировать по имени, по дате, по цвету
                    when(noteOrder){
                        is NoteOrder.Title->{
                            // через sortedBy идёт сортировка, с помощью lowercase делаем все буквы строчными
                            notes.sortedBy { it.title.lowercase() }
                        }
                        is NoteOrder.Date->{
                            notes.sortedBy { it.timestamp }
                        }
                        is NoteOrder.Color->{
                            notes.sortedBy { it.color }
                        }
                    }
                }

                is OrderType.Descending->{
                    when(noteOrder){
                        is NoteOrder.Title->{
                            notes.sortedByDescending { it.title.lowercase() }
                        }
                        is NoteOrder.Date->{
                            notes.sortedByDescending { it.timestamp }
                        }
                        is NoteOrder.Color->{
                            notes.sortedByDescending { it.color }
                        }
                    }
                }
            }
        }
    }
}