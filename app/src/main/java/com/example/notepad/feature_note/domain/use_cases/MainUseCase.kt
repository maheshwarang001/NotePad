package com.example.notepad.feature_note.domain.use_cases

data class MainUseCase(
    val getNotes: GetNotesUseCase,
    val deleteNotes: DeleteNotesUseCase,
    val editeNotes: AddNotesUseCase
)