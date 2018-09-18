package com.example.app.roomdatabase.Room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "student")
data class Student(@PrimaryKey var id: String,
                   var name: String,
                   var phone: Long,
                   var email: String,
                   var address: String,
                   var enrollno: Long){
    constructor():
            this("","",-1,"","",-1)
}