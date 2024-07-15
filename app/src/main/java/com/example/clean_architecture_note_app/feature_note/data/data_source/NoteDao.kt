package com.example.clean_architecture_note_app.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

// так как в данном интерфейсе будут запросы к бд помечаим их Dao
@Dao
interface NoteDao {

    @Query("SELECT * FROM notemodel")
    fun getNote(): Flow<List<NoteModel>>

    @Query("SELECT * FROM notemodel WHERE id=:id")
    suspend fun getNoteById(id:Int):NoteModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)
}