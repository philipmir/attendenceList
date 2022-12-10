package com.example.attendencelist

import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val STUDENT_POSITION_KEY = "STUDENT_POSITION"
const val POSITION_NOT_SET = -1

class CreateAndEditStudentActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var classEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_edit_student)

        nameEditText = findViewById(R.id.nameEditText)
        classEditText = findViewById(R.id.classEditText)
        val studentPosition = intent.getIntExtra(STUDENT_POSITION_KEY, POSITION_NOT_SET)

        val saveButton = findViewById<Button>(R.id.saveButton)
        if (studentPosition != POSITION_NOT_SET) { // edit student
            displayStudent(studentPosition)
            saveButton.setOnClickListener {
                editStudent(studentPosition)
            }

        } else {                                    // create student
            saveButton.setOnClickListener {
                addNewStudent()
            }
        }
    }

    fun displayStudent(position: Int) {
        val student = DataManager.students[position]

        nameEditText.setText(student.name)
        classEditText.setText(student.className)

    }

    fun editStudent(position: Int) {
        DataManager.students[position].name = nameEditText.text.toString()
        DataManager.students[position].className = classEditText.text.toString()

        finish()
    }


    fun addNewStudent() {
        val name = nameEditText.text.toString()
        val className = classEditText.text.toString()

        val student = Student(name, className)
        DataManager.students.add(student)
        finish()
    }

}