package dev.enritech.jccatalog.ui

data class TodoInfo(
    val title: String,
    val done: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)