package com.example.gestion_de_tareas

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTask)
        taskAdapter = TaskAdapter(TaskModel.getTasks(), this::markTaskCompleted, this::deleteTask)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.buttonAddTask).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AddTaskFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun markTaskCompleted(id: Int) {
        TaskModel.markTaskCompleted(id)
        taskAdapter.notifyDataSetChanged()
    }

    private fun deleteTask(id: Int) {
        TaskModel.deleteTask(id)
        taskAdapter.notifyDataSetChanged()
    }
}
