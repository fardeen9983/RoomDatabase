package com.example.app.roomdatabase

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app.roomdatabase.Room.Student
import com.example.app.roomdatabase.Room.StudentDatabase
import kotlinx.android.synthetic.main.activity_add_student.*

class AddStudent : AppCompatActivity() {
    private lateinit var studentVM: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        studentVM = ViewModelProviders.of(this).get(StudentViewModel::class.java)

        save.setOnClickListener {
            val student = Student(idno.text.toString(), name.text.toString(), phone.text.toString().toLong(), email.text.toString())
            studentVM.insert(student)
           // startActivity(Intent(this, MainActivity::class.java))
        }
    }
}

