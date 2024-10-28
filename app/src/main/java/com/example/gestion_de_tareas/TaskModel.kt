package com.example.gestion_de_tareas

object TaskModel {
    private val taskList = mutableListOf<Task>()
    private var nextId = 1

    fun addTask(title: String, description: String) {
        val task = Task(id = nextId++, title = title, description = description)
        taskList.add(task)
    }

    fun getTasks(): List<Task> = taskList

    fun markTaskCompleted(id: Int) {
        taskList.find { it.id == id }?.completed = true
    }

    fun deleteTask(id: Int) {
        taskList.removeAll { it.id == id }
    }
}
