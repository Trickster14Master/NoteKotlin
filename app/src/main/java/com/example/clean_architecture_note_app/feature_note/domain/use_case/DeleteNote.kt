package com.example.clean_architecture_note_app.feature_note.domain.use_case

import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNote  @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteModel){
        repository.deleteNote(note)
    }
}