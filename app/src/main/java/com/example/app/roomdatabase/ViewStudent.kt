package com.example.app.roomdatabase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.app.roomdatabase.Room.Student
import kotlinx.android.synthetic.main.activity_view_student.*

class ViewStudent : AppCompatActivity() {

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        if (intent != null)
            student = intent.getSerializableExtra("student") as Student?

        save.setOnClickListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.edit) {
            setEditable()
            save.visibility = View.VISIBLE
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun setEditable() {

    }
}
