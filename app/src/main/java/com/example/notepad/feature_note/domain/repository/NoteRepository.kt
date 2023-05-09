package com.example.notepad.feature_note.domain.repository

import com.example.notepad.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getnotes():Flow<List<Notes>>

    suspend fun getNoteBYID(id:Int):Notes?

    suspend fun insertNote(notes: Notes)

    suspend fun deleteNote(notes: Notes)

}