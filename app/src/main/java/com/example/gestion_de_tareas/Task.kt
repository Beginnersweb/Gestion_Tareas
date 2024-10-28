package com.example.gestion_de_tareas

data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var completed: Boolean = false
)