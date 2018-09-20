package com.example.app.roomdatabase

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.app.roomdatabase.Room.Student
import com.example.app.roomdatabase.Room.StudentDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var studentVM : StudentViewModel
    private lateinit var DB: StudentDatabase
    private var students: List<Student>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentVM = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentVM.getAllStudents().observe(this, Observer { it ->
            studList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,it)
        })

        studList.emptyView = emptyView

        studList.setOnItemClickListener { a, _, pos, _ ->
            val student = a.getItemAtPosition(pos) as Student
            val intent = Intent(this, ViewStudent::class.java)
            intent.putExtra("id",student.id)
            startActivity(intent)
        }

        add.setOnClickListener {
            startActivity(Intent(this,AddStudent::class.java))
        }
    }


}
