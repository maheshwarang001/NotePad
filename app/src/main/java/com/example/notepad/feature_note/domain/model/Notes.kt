package com.example.notepad.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notepad.ui.theme.BabyBlue
import com.example.notepad.ui.theme.LightGreen
import com.example.notepad.ui.theme.RedOrange
import com.example.notepad.ui.theme.RedPink
import com.example.notepad.ui.theme.Violet

@Entity
data class Notes(
    val title:String,
    val content: String,
    val timeStamp:Long,
    val color:Int,

    @PrimaryKey
    val id: Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidException(msg: String): Exception(msg)