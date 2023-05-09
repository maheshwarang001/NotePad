package com.example.notepad.feature_note.presentation.notes_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.use_cases.MainUseCase
import com.example.notepad.feature_note.domain.util.NoteOrder
import com.example.notepad.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state
    private var lastNote: Notes? = null

    private var notesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Desceding))
    }


    fun onEvent(events: NotesEvents) {

        when (events) {
            is NotesEvents.Order -> {
                if (state.value.noteOrder::class == events.noteOrder::class &&
                    state.value.noteOrder.orderType == events.noteOrder.orderType
                ) {
                    return
                }

            }

            is NotesEvents.DeleteNotes -> {
                viewModelScope.launch {
                    lastNote = events.notes
                    useCase.deleteNotes(events.notes)
                }

            }

            is NotesEvents.RestoreNote -> {
                viewModelScope.launch {

                    useCase.editeNotes(lastNote ?: return@launch)
                    lastNote = null
                }
            }

            is NotesEvents.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }


    private fun getNotes(noteOrder: NoteOrder) {
        notesJob?.cancel()

        notesJob = useCase.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }.launchIn(viewModelScope)
    }

}