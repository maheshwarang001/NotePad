package com.example.notepad.feature_note.domain.use_cases

import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.repository.NoteRepository

class DeleteNotesUseCase (
    private val repository: NoteRepository
        ){

    suspend operator fun invoke(note:Notes){
        repository.deleteNote(note)
    }

}