package com.example.notepad.feature_note.data.repository

import com.example.notepad.feature_note.data.data_source.NoteDAO
import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepoImplementation(private val dao: NoteDAO):NoteRepository {

    override fun getnotes(): Flow<List<Notes>> {
        return dao.getNotes()
    }

    override suspend fun getNoteBYID(id: Int): Notes? {
        return dao.getNoteBYID(id)
    }

    override suspend fun insertNote(notes: Notes) {
        return dao.insertNote(notes)
    }

    override suspend fun deleteNote(notes: Notes) {
        return dao.deleteNote(notes)
    }
}