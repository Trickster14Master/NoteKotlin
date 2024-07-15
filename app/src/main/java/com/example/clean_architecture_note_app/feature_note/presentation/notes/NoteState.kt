package com.example.clean_architecture_note_app.feature_note.presentation.notes

import com.example.clean_architecture_note_app.feature_note.domain.model.NoteModel
import com.example.clean_architecture_note_app.feature_note.domain.util.NoteOrder
import com.example.clean_architecture_note_app.feature_note.domain.util.OrderType

// в данном классе описываются состояния в которые будкт взаимодействовать с ивентами
data class NoteState(
    val note:List<NoteModel> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false
)
