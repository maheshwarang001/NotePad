package com.example.notepad.feature_note.presentation.notes_screen

import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.util.NoteOrder
import com.example.notepad.feature_note.domain.util.OrderType

data class NoteState(

    val notes: List<Notes> = emptyList(),
    val noteOrder:  NoteOrder = NoteOrder.Date(OrderType.Desceding),
    val isOrderSectionVisible: Boolean = false

)
