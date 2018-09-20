package com.example.app.roomdatabase.Room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Student::class], version = 1,exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDAO(): StudentDAO

    companion object {
        private var INSTANCE: StudentDatabase? = null

        fun getInstance(context: Context): StudentDatabase? {
            synchronized(StudentDatabase::class) {
                if (INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(context.applicationContext, StudentDatabase::class.java,
                            "student.db").allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }

    fun destroyInstance() {
        INSTANCE = null
    }
}