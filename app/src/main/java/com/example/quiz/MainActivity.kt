package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val anatomyButton = findViewById<Button>(R.id.anatomyButton)
        val biosignalsButton = findViewById<Button>(R.id.biosignalsButton)
        val biomaterialsButton = findViewById<Button>(R.id.biomaterialsButton)
        val medicalequipButton = findViewById<Button>(R.id.medicalequipButton)
        val allButton = findViewById<Button>(R.id.allButton)

        anatomyButton.setOnClickListener {

            val intent = Intent(this, QuizInfoActivity::class.java)
            intent.putExtra("category", "Anatomia i fizjologia")
            startActivity(intent)
        }

        biosignalsButton.setOnClickListener {

            val intent = Intent(this, QuizInfoActivity::class.java)
            intent.putExtra("category", "Biosygnały")
            startActivity(intent)
        }

        biomaterialsButton.setOnClickListener {

            val intent = Intent(this, QuizInfoActivity::class.java)
            intent.putExtra("category", "Biomateriały")
            startActivity(intent)
        }

        medicalequipButton.setOnClickListener {

            val intent = Intent(this, QuizInfoActivity::class.java)
            intent.putExtra("category", "Aparatura medyczna")
            startActivity(intent)
        }

        allButton.setOnClickListener {

            val intent = Intent(this, QuizInfoActivity::class.java)
            intent.putExtra("category", "Wszystko")
            startActivity(intent)
        }


    }
}