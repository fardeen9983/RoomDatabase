package com.example.app.roomdatabase

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.app.roomdatabase.Room.Student

class StudentViewModel constructor(application: Application) : AndroidViewModel(application) {

    private var stuRepo = StudentRepository(application)
    private var studentList = stuRepo.getAllStudents()
    fun getAllStudents() = studentList
    fun insert(student: Student) = stuRepo.insertStudent(student)
    fun update(student: Student) = stuRepo.updateStudent(student)
    fun getStudent(id : String) = stuRepo.getStudent(id)
}