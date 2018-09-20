package com.example.app.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.app.roomdatabase.Room.Student
import com.example.app.roomdatabase.Room.StudentDatabase
import kotlinx.android.synthetic.main.activity_view_student.*

class ViewStudent : AppCompatActivity() {

    private var student: Student? = null
    private var DB: StudentDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        DB = StudentDatabase.getInstance(this)

        if (intent != null) {
            student = DB?.studentDAO()?.getStudent(intent.getStringExtra("id"))
            idno.setText(student?.id)
            name.setText(student?.name)
            phone.setText(student?.phone.toString())
            email.setText(student?.email)
        }
        save.setOnClickListener {
            student = Student(idno.text.toString(), name.text.toString(),
                    phone.text.toString().toLong(), email.text.toString())
            DB?.studentDAO()?.update(student!!)
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.edit) {
            setEditable()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun setEditable() {

    }
}
