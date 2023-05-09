package com.example.notepad.feature_note.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Desceding: OrderType()
}
