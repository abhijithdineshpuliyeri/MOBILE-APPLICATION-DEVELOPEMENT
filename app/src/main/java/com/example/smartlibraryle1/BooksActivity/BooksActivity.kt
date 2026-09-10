package com.example.smartlibraryle1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val alchemist = findViewById<Button>(R.id.issueAlchemist)
        val atomic = findViewById<Button>(R.id.issueAtomic)
        val cleanCode = findViewById<Button>(R.id.issueCleanCode)
        val harry = findViewById<Button>(R.id.issueHarry)
        val richDad = findViewById<Button>(R.id.issueRichDad)

        alchemist.setOnClickListener {
            openIssueScreen("The Alchemist", "Paulo Coelho")
        }

        atomic.setOnClickListener {
            openIssueScreen("Atomic Habits", "James Clear")
        }

        cleanCode.setOnClickListener {
            openIssueScreen("Clean Code", "Robert C. Martin")
        }

        harry.setOnClickListener {
            openIssueScreen("Harry Potter", "J. K. Rowling")
        }

        richDad.setOnClickListener {
            openIssueScreen("Rich Dad Poor Dad", "Robert Kiyosaki")
        }
    }

    private fun openIssueScreen(book: String, author: String) {

        val intent = Intent(this, IssueActivity::class.java)

        intent.putExtra("BOOK_NAME", book)
        intent.putExtra("AUTHOR_NAME", author)

        startActivity(intent)
    }
}