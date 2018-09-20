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
    private var students: List<Student> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DB = StudentDatabase.getInstance(this)!!
        getStudents()
        studList.emptyView = emptyView
        studList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, students)

        studList.setOnItemClickListener { a, b, pos, c ->
            val student = a.getItemAtPosition(pos) as Student
            val intent = Intent(this, ViewStudent::class.java)
            intent.putExtra("id",student.id)
            startActivity(intent)
        }

        add.setOnClickListener {
            startActivity(Intent(this,AddStudent::class.java))
        }
    }

    fun getStudents() {
            students = DB.studentDAO().getAllStudents()
    }

}
