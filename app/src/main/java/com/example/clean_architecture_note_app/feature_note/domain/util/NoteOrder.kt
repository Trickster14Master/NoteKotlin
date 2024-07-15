package com.example.clean_architecture_note_app.feature_note.domain.util

// класс благодаря которому мы будем сортеровать элементы по названию, дате, цвету
sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType):NoteOrder(orderType)
    class Date(orderType: OrderType):NoteOrder(orderType)
    class Color(orderType: OrderType):NoteOrder(orderType)

    // данная функция нужна для того что бы можно было скопировать фильтор и передать в него новые параметры
    fun copy(orderType: OrderType):NoteOrder{
        return when(this){
            is Title->Title(orderType)
            is Date->Date(orderType)
            is Color->Color(orderType)
        }
    }
}