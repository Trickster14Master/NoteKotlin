package com.example.clean_architecture_note_app.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.clean_architecture_note_app.ui.theme.LightBlue
import com.example.clean_architecture_note_app.ui.theme.LightGreen
import com.example.clean_architecture_note_app.ui.theme.RedOrange
import com.example.clean_architecture_note_app.ui.theme.Violet
import java.sql.Timestamp

// так как это клас будет использоваться в Room надо его пометить Entity
@Entity
data class NoteModel(
    val title:String,
    val content:String,
    val timestamp: Long,
    val color:Int,
    @PrimaryKey val id:Int?=null,
){
    // функция с помощью которой ограничиваем цвета
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, Color.White)
    }
}