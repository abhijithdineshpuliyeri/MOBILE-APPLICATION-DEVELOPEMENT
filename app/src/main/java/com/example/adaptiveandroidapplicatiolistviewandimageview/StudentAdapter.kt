package com.example.adaptiveandroidapplicatiolistviewandimageview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class StudentAdapter(
    private val context: Context,
    private val students: List<Student>
) : ArrayAdapter<Student>(context, 0, students) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val student: Student = students[position]

        val row = LinearLayout(context)

        row.orientation = LinearLayout.HORIZONTAL
        row.gravity = Gravity.CENTER_VERTICAL
        row.setPadding(20, 16, 20, 16)

        // ImageView
        val imageView = ImageView(context)

        val imageResource: Int = context.resources.getIdentifier(
            student.imageName,
            "drawable",
            context.packageName
        )

        if (imageResource != 0) {
            imageView.setImageResource(imageResource)
        } else {
            imageView.setImageResource(
                android.R.drawable.ic_menu_gallery
            )
        }

        imageView.scaleType = ImageView.ScaleType.CENTER_CROP

        val imageParams = LinearLayout.LayoutParams(
            90,
            90
        )

        imageParams.gravity = Gravity.CENTER_VERTICAL

        imageView.layoutParams = imageParams

        row.addView(imageView)

        // Text container
        val textLayout = LinearLayout(context)

        textLayout.orientation = LinearLayout.VERTICAL
        textLayout.gravity = Gravity.CENTER_VERTICAL
        textLayout.setPadding(25, 0, 0, 0)

        // Student name
        val nameText = TextView(context)

        nameText.text = student.name
        nameText.textSize = 18f
        nameText.setTextColor(Color.BLACK)

        // Course
        val courseText = TextView(context)

        courseText.text = student.course
        courseText.textSize = 14f
        courseText.setTextColor(Color.DKGRAY)

        textLayout.addView(nameText)
        textLayout.addView(courseText)

        row.addView(
            textLayout,
            LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        )

        return row
    }
}