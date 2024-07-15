package com.example.clean_architecture_note_app.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.use_case.NoteUseCases
import com.example.clean_architecture_note_app.feature_note.domain.util.NoteOrder
import com.example.clean_architecture_note_app.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
):ViewModel(){
    // переменная для хранения состояния
    private val _state= mutableStateOf(NoteState())
    val state:State<NoteState> = _state

    // переменная для хранения последней удалённой модели
    private var recentlyDeletedNote:NoteModel?=null

    // переменная которая определяет был ли запущен поток для getNote
    private var getNoteJob:Job?=null

    init {
        getNote(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order->{
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType){
                    return
                }
                getNote(event.noteOrder)

            }

            is NotesEvent.DeleteNote->{
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NotesEvent.RestoreNote->{
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?:return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NotesEvent.ToggleOrderSection->{
                _state.value=state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNote(noteOrder:NoteOrder){
        // перед вызовом всех записей, отчищаем поток
        getNoteJob?.cancel()
        // песле отчистки закидываем в поток задау по получению всех записей
        getNoteJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    note = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}