package com.example.clean_architecture_note_app.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel

// инициализируем БД
@Database(
    // казываем какие таблици сделать на основе ранее написанных классов
    entities = [NoteModel::class],
    // версия БД
    version = 1
)
abstract class NoteDB:RoomDatabase() {
    abstract val noteDao:NoteDao

    companion object{
        const val DATABASE_NAME = "notes_db"
    }
}