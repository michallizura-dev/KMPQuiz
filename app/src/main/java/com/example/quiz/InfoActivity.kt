package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_info)

        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {

            val intent =
                Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}