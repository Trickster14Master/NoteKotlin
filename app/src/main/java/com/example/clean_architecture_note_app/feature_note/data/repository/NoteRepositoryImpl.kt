package com.example.clean_architecture_note_app.feature_note.data.repository

import com.example.clean_architecture_note_app.feature_note.data.data_source.NoteDao
import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
):NoteRepository {
    override fun getNotes(): Flow<List<NoteModel>> {
        return dao.getNote()
    }

    override suspend fun getNoteById(id: Int): NoteModel? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: NoteModel) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: NoteModel) {
        return dao.deleteNote(note)
    }
}