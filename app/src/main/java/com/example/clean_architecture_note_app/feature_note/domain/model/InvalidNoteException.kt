package com.example.clean_architecture_note_app.feature_note.domain.model

// класс для обработки исключений
class InvalidNoteException(message:String):Exception(message)