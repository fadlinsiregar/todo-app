package com.dicoding.todoapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.ui.list.TaskActivity
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {
    private lateinit var detailTaskViewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val factory = ViewModelFactory.getInstance(this)
        detailTaskViewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)

        val id = intent.getIntExtra(TASK_ID, 0)
        detailTaskViewModel.setTaskId(id)

        val title = findViewById<EditText>(R.id.detail_ed_title)
        val description = findViewById<EditText>(R.id.detail_ed_description)
        val dueDate = findViewById<EditText>(R.id.detail_ed_due_date)

        detailTaskViewModel.task.observe(this) { task ->
            if (task != null) {
                title.setText(task.title)
                description.setText(task.description)
                dueDate.setText(DateConverter.convertMillisToString(task.dueDateMillis))
            }
        }

        findViewById<Button>(R.id.btn_delete_task).setOnClickListener {
            finish()
            detailTaskViewModel.deleteTask()
            Toast.makeText(this@DetailTaskActivity, "Task is successfully removed!", Toast.LENGTH_SHORT).show()
        }
    }
}