package com.example.biomedquiz

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Question(
        val question: String,
        val answers: List<String>,
        val correctAnswer: Int
    )

    private val questions = listOf(

        Question(
            "Jakie urządzenie służy do rejestracji aktywności elektrycznej serca?",
            listOf("EEG", "EMG", "EKG", "USG"),
            2
        ),

        Question(
            "Jak nazywa się sygnał elektryczny mózgu?",
            listOf("EKG", "EEG", "EMG", "RTG"),
            1
        ),

        Question(
            "Który narząd odpowiada za pompowanie krwi?",
            listOf("Płuco", "Wątroba", "Serce", "Nerka"),
            2
        )

    )

    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var answer1: RadioButton
    private lateinit var answer2: RadioButton
    private lateinit var answer3: RadioButton
    private lateinit var answer4: RadioButton
    private lateinit var nextButton: Button
    private lateinit var scoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionText = findViewById(R.id.questionText)
        radioGroup = findViewById(R.id.radioGroup)

        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        nextButton = findViewById(R.id.nextButton)
        scoreText = findViewById(R.id.scoreText)

        loadQuestion()

        nextButton.setOnClickListener {

            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "Wybierz odpowiedź", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedIndex = when (selectedId) {
                R.id.answer1 -> 0
                R.id.answer2 -> 1
                R.id.answer3 -> 2
                else -> 3
            }

            if (selectedIndex == questions[currentQuestionIndex].correctAnswer) {
                score++
            }

            currentQuestionIndex++

            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                showFinalScore()
            }
        }
    }

    private fun loadQuestion() {

        radioGroup.clearCheck()

        val currentQuestion = questions[currentQuestionIndex]

        questionText.text = currentQuestion.question

        answer1.text = currentQuestion.answers[0]
        answer2.text = currentQuestion.answers[1]
        answer3.text = currentQuestion.answers[2]
        answer4.text = currentQuestion.answers[3]

        scoreText.text = "Pytanie ${currentQuestionIndex + 1}/${questions.size}"
    }

    private fun showFinalScore() {

        questionText.text = "Koniec quizu!"

        radioGroup.visibility = RadioGroup.GONE
        nextButton.visibility = Button.GONE

        scoreText.text = "Twój wynik: $score / ${questions.size}"
    }
}