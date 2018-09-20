package com.example.app.roomdatabase

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app.roomdatabase.Room.Student
import kotlinx.android.synthetic.main.activity_view_student.*

class ViewStudent : AppCompatActivity() {

    private lateinit var studentVM: StudentViewModel
    private var student: Student? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)
        studentVM = ViewModelProviders.of(this).get(StudentViewModel::class.java)

        if (intent != null) {
            student = studentVM.getStudent(intent.getStringExtra("id"))
            idno.setText(student?.id)
            name.setText(student?.name)
            phone.setText(student?.phone.toString())
            email.setText(student?.email)
        }
        save.setOnClickListener {
            student = Student(idno.text.toString(), name.text.toString(),
                    phone.text.toString().toLong(), email.text.toString())
            studentVM.update(student!!)
            //startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
