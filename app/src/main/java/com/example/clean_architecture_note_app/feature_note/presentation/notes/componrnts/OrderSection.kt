package com.example.clean_architecture_note_app.feature_note.presentation.notes.componrnts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clean_architecture_note_app.feature_note.domain.util.NoteOrder
import com.example.clean_architecture_note_app.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Title",
                // делаем так чтобы select был выбран если в noteOrder выбран Title
                select = noteOrder is NoteOrder.Title,
                onSelect = {
                    // при нажатии на кнопку в noteOrder(фильтор) мы выбираем сортировать по Title
                    onOrderChange(NoteOrder.Title(noteOrder.orderType))
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Date",
                // делаем так чтобы select был выбран если в noteOrder выбран Title
                select = noteOrder is NoteOrder.Date,
                onSelect = {
                    // при нажатии на кнопку в noteOrder(фильтор) мы выбираем сортировать по Date
                    onOrderChange(NoteOrder.Date(noteOrder.orderType))
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Color",
                // делаем так чтобы select был выбран если в noteOrder выбран Title
                select = noteOrder is NoteOrder.Color,
                onSelect = {
                    // при нажатии на кнопку в noteOrder(фильтор) мы выбираем сортировать по Color
                    onOrderChange(NoteOrder.Color(noteOrder.orderType))
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "По возростанию",
                // делаем так чтобы select был выбран если в noteOrder выбран Title
                select = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    // при нажатии на кнопку в noteOrder(фильтор) мы выбираем сортировать по возростанию
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "По убыванию",
                // делаем так чтобы select был выбран если в noteOrder выбран Title
                select = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    // при нажатии на кнопку в noteOrder(фильтор) мы выбираем сортировать по убыванию
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}