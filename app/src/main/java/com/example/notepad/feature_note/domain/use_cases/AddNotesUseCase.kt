package com.example.notepad.feature_note.domain.use_cases

import com.example.notepad.feature_note.domain.model.InvalidException
import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.repository.NoteRepository

class AddNotesUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidException::class)
    suspend operator fun invoke(note: Notes){

        if(note.title.isBlank()){
            throw InvalidException("cant be empty")
        }
        if(note.content.isBlank()){
            throw InvalidException("cant be empty")
        }
        repository.insertNote(note)
    }
}