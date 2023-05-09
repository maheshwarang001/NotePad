package com.example.notepad.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepad.feature_note.domain.model.Notes


@Database(
    entities = [Notes::class],
    version = 1
)

abstract class DB:RoomDatabase() {

    abstract val noteDAO:NoteDAO

    companion object{
        const val DATABASE_NAME = "notes_DB"
    }
}