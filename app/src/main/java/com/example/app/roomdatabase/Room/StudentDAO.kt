package com.example.app.roomdatabase.Room

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface StudentDAO {

    @Insert(onConflict = REPLACE)
    fun insert(student: Student)

    @Insert(onConflict = REPLACE)
    fun insertAll(students: List<Student>)

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudent(id: String): Student

    @Query("SELECT * FROM student")
    fun getAllStudents() : List<Student>

    @Update(onConflict = REPLACE)
    fun update(student: Student)

    @Update(onConflict = REPLACE)
    fun updateAll(students: List<Student>)

    @Delete
    fun delete(student: Student)

    @Query("DELETE FROM student")
    fun deleteAll()
}