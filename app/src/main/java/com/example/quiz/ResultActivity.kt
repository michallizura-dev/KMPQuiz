package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val resultText = findViewById<TextView>(R.id.resultText)
        val backButton = findViewById<Button>(R.id.backButton)

        resultText.text = "Twój wynik: $score / $total"

        backButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}