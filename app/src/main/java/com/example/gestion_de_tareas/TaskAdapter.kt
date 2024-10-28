package com.example.gestion_de_tareas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val tasks: List<Task>,
    private val onTaskCompleted: (Int) -> Unit,
    private val onTaskDeleted: (Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.taskTitle)
        val deleteIcon = view.findViewById<ImageView>(R.id.deleteIcon)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBoxCompleted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.title.text = task.title
        holder.checkBox.isChecked = task.completed

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) onTaskCompleted(task.id)
        }
        holder.deleteIcon.setOnClickListener { onTaskDeleted(task.id) }
    }

    override fun getItemCount() = tasks.size
}
