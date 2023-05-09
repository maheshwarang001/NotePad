package com.example.notepad.feature_note.domain.use_cases

import com.example.notepad.feature_note.domain.model.Notes
import com.example.notepad.feature_note.domain.repository.NoteRepository
import com.example.notepad.feature_note.domain.util.NoteOrder
import com.example.notepad.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Desceding)
    ):Flow<List<Notes>>{

        return repository.getnotes().map { notes->
            when(noteOrder.orderType){
                is OrderType.Ascending->{
                    when(noteOrder){
                        is NoteOrder.Date-> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Title-> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color-> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Desceding->{
                    when(noteOrder){
                        is NoteOrder.Date-> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Title-> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color-> notes.sortedBy { it.color }
                    }
                }

            }
        }
    }

}