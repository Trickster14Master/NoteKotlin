package com.example.clean_architecture_note_app.feature_note.presentation.add_edit_note

// описываем то какние поля будут заполлняться на экране создания заметки
data class NoteTextFieldState(
    val text:String = "",
    val hint:String = "",
    val isHintVisible:Boolean = true
)