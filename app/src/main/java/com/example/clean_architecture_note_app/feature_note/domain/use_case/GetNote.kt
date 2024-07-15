package com.example.clean_architecture_note_app.feature_note.domain.use_case

import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): NoteModel? {
        return repository.getNoteById(id)
    }
}