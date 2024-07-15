package com.example.clean_architecture_note_app.feature_note.domain.use_case

import com.example.clean_architecture_note_app.feature_note.domain.model.InvalidNoteException
import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.repository.NoteRepository
import javax.inject.Inject
import kotlin.jvm.Throws

class AddNote @Inject constructor(
    private val repository: NoteRepository
){
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(noteModel: NoteModel){
        if(noteModel.title.isBlank()){
            throw InvalidNoteException("Поле для названия не может быть пустым")
        }
        if(noteModel.content.isBlank()){
            throw InvalidNoteException("Поле для содержимого не может быть пустым")
        }
        repository.insertNote(noteModel)
    }
}