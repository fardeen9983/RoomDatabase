package com.example.app.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app.roomdatabase.Room.Student
import com.example.app.roomdatabase.Room.StudentDatabase
import kotlinx.android.synthetic.main.activity_add_student.*

class AddStudent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        save.setOnClickListener {
            val student = Student(idno.text.toString(), name.text.toString(), phone.text.toString().toLong(), email.text.toString())
            val DB: StudentDatabase? = StudentDatabase.getInstance(this)
            DB?.studentDAO()?.insert(student)
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}

