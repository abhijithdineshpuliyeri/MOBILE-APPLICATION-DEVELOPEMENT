package com.example.smartlibraryle1

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class IssueActivity : AppCompatActivity() {

    private val channelId = "library_notifications"
    private val notificationId = 1001
    private val notificationPermissionCode = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue)

        val bookName = intent.getStringExtra("BOOK_NAME") ?: "Book"
        val authorName = intent.getStringExtra("AUTHOR_NAME") ?: "Unknown Author"

        val bookNameText = findViewById<TextView>(R.id.bookName)
        val authorNameText = findViewById<TextView>(R.id.authorName)
        val confirmButton = findViewById<Button>(R.id.confirmButton)

        bookNameText.text = bookName
        authorNameText.text = authorName

        createNotificationChannel()

        confirmButton.setOnClickListener {

            // Android 13+ notification permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    notificationPermissionCode
                )

            } else {

                issueBook(bookName)
            }
        }
    }

    private fun issueBook(bookName: String) {

        showNotification(bookName)

        Toast.makeText(
            this,
            "Book issued successfully!",
            Toast.LENGTH_SHORT
        ).show()

        // Go back to Home
        val intent = Intent(this, MainActivity::class.java)

        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP

        startActivity(intent)

        finish()
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                channelId,
                "Library Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.description =
                "Notifications for issued library books"

            val notificationManager =
                getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification(bookName: String) {

        val notification = NotificationCompat.Builder(
            this,
            channelId
        )
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("SmartLibrary")
            .setContentText(
                "$bookName has been issued successfully."
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .build()

        if (
            Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            NotificationManagerCompat
                .from(this)
                .notify(notificationId, notification)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        if (requestCode == notificationPermissionCode) {

            if (grantResults.isNotEmpty() &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {

                val bookName =
                    intent.getStringExtra("BOOK_NAME") ?: "Book"

                issueBook(bookName)

            } else {

                Toast.makeText(
                    this,
                    "Notification permission denied",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}