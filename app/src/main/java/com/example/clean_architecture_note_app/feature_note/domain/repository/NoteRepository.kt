package com.example.clean_architecture_note_app.feature_note.domain.repository

import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<NoteModel>>

    suspend fun getNoteById(id:Int):NoteModel?

    suspend fun insertNote(note:NoteModel)

    suspend fun deleteNote(note: NoteModel)
}