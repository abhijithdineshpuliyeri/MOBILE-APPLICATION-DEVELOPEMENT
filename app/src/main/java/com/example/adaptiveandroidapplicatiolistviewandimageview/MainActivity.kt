package com.example.adaptiveandroidapplicatiolistviewandimageview

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout = LinearLayout(this)
        mainLayout.orientation = LinearLayout.VERTICAL
        mainLayout.setPadding(20, 20, 20, 20)
        mainLayout.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "Student List"
        title.textSize = 24f
        title.setTextColor(Color.BLACK)
        title.gravity = Gravity.CENTER
        title.setPadding(0, 20, 0, 30)

        mainLayout.addView(
            title,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val listView = ListView(this)

        val students: List<Student> = listOf(
            Student(
                name = "Abhijith",
                course = "MCA Student",
                imageName = "student1"
            ),
            Student(
                name = "Rahul",
                course = "MCA Student",
                imageName = "student2"
            ),
            Student(
                name = "Arjun",
                course = "MCA Student",
                imageName = "student3"
            ),
            Student(
                name = "Anjali",
                course = "MCA Student",
                imageName = "student4"
            )
        )

        val adapter = StudentAdapter(
            this,
            students
        )

        listView.adapter = adapter

        mainLayout.addView(
            listView,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Selected: ${students[position].name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        setContentView(mainLayout)
    }
}