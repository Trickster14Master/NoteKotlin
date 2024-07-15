package com.example.clean_architecture_note_app.feature_note.presentation.notes

import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder):NotesEvent()
    data class DeleteNote(val note:NoteModel):NotesEvent()
    object RestoreNote:NotesEvent()
    object ToggleOrderSection:NotesEvent()
}
