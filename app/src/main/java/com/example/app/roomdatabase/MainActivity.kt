package com.example.app.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.app.roomdatabase.Room.Student
import com.example.app.roomdatabase.Room.StudentDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var DB: StudentDatabase
    private lateinit var students: MutableList<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DB = StudentDatabase.getInstance(this)!!
        getStudents()
        studList.emptyView = emptyView
        studList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, students)

        studList.setOnItemClickListener { _, _, pos, _ ->
            val student = DB.studentDAO().getStudent(pos.toString())
            val intent = Intent(this, ViewStudent::class.java)
            intent.putExtra("student", student)
            startActivity(intent)
        }
    }

    fun getStudents() {
        Runnable {
            students = DB.studentDAO().getAllStudents()
        }
    }

}
