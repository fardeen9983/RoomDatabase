package com.example.app.roomdatabase

import android.app.Application
import com.example.app.roomdatabase.Room.Student
import com.example.app.roomdatabase.Room.StudentDatabase


class StudentRepository(application: Application) {
    private var DB: StudentDatabase = StudentDatabase.getInstance(application)!!
    private var studentList = DB.studentDAO().getAllStudents()

    fun getAllStudents() = studentList
    fun insertStudent(student: Student) = DB.studentDAO().insert(student)
    fun updateStudent(student: Student) = DB.studentDAO().update(student)
    fun getStudent(id : String) = DB.studentDAO().getStudent(id)
}