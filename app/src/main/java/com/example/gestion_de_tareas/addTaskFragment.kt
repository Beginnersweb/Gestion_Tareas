package com.example.gestion_de_tareas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        val titleInput = view.findViewById<EditText>(R.id.editTextTitle)
        val descriptionInput = view.findViewById<EditText>(R.id.editTextDescription)

        view.findViewById<Button>(R.id.buttonSaveTask).setOnClickListener {
            val title = titleInput.text.toString()
            val description = descriptionInput.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()) {
                TaskModel.addTask(title, description)
                fragmentManager?.popBackStack()
            } else {
                Toast.makeText(activity, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
