package com.example.notepad.feature_note.presentation.notes_screen

import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.util.NoteOrder

sealed class NotesEvents{
    data class Order(val noteOrder: NoteOrder):NotesEvents()
    data class DeleteNotes(val notes:Notes):NotesEvents()
    object RestoreNote:NotesEvents()
    object ToggleOrderSection: NotesEvents()
}