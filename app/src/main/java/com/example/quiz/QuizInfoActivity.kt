package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_quiz_info)

        val category =
            intent.getStringExtra("category") ?: ""

        val infoText =
            findViewById<TextView>(R.id.infoText)

        val startButton =
            findViewById<Button>(R.id.startQuizButton)

        val questionCount = 10

        infoText.text =
            "Kategoria: $category\n\n" +
                    "Liczba pytań: $questionCount\n\n" +
                    "Pytania będą losowane."

        startButton.setOnClickListener {

            val intent =
                Intent(this, QuizActivity::class.java)

            intent.putExtra("category", category)

            startActivity(intent)
        }
    }
}