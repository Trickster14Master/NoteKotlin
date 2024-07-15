package com.example.clean_architecture_note_app.feature_note.domain.util

// класс благодаря которому мы будем сортеровать элементы по ибыванию или возростанию
sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()

}
