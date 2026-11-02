package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    //Zmienne
    private lateinit var questionText: TextView
    private lateinit var questionImage: ImageView
    private lateinit var answer1: Button
    private lateinit var answer2: Button
    private lateinit var answer3: Button
    private lateinit var answer4: Button
    private lateinit var questionCounter: TextView
    private lateinit var quizProgressBar: ProgressBar
    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var questions: List<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_quiz)


        questionText = findViewById(R.id.questionText)
        questionImage = findViewById(R.id.questionImage)
        questionCounter = findViewById(R.id.questionCounter)
        quizProgressBar = findViewById(R.id.quizProgressBar)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        val category =
            intent.getStringExtra("category") ?: ""

        questions = if (category == "Wszystko") {

            QuestionRepository.questions
                .shuffled()
                .take(10)

        } else {

            QuestionRepository.questions
                .filter { it.category == category }
                .shuffled()
                .take(10)
        }

        setAnswerClick(answer1, 0)
        setAnswerClick(answer2, 1)
        setAnswerClick(answer3, 2)
        setAnswerClick(answer4, 3)

        loadQuestion()
    }

    private fun loadQuestion() {

        resetButtonStyles()

        questionImage.clearAnimation()
        questionImage.alpha = 1f

        val currentQuestion =
            questions[currentQuestionIndex]

        //Pasek postępu quizu
        quizProgressBar.max = questions.size
        quizProgressBar.progress = currentQuestionIndex + 1

        //Informacja na którym pytaniu się znajdujemy
        questionCounter.text =
            "Pytanie ${currentQuestionIndex + 1} z ${questions.size}"

        //Zmienne animacji
        val fadeOut =
            AnimationUtils.loadAnimation(this, R.anim.fade_out)

        val fadeIn =
            AnimationUtils.loadAnimation(this, R.anim.fade_in)

        questionText.startAnimation(fadeOut)

        answer1.startAnimation(fadeOut)
        answer2.startAnimation(fadeOut)
        answer3.startAnimation(fadeOut)
        answer4.startAnimation(fadeOut)

        questionImage.startAnimation(fadeOut)

        questionText.text =
            currentQuestion.question

        answer1.text =
            currentQuestion.answers[0]

        answer2.text =
            currentQuestion.answers[1]

        answer3.text =
            currentQuestion.answers[2]

        answer4.text =
            currentQuestion.answers[3]

        if (currentQuestion.imageResId != null) {

            questionImage.visibility = View.VISIBLE

            questionImage.setImageResource(
                currentQuestion.imageResId
            )

        } else {

            questionImage.setImageDrawable(null)

            questionImage.visibility = View.GONE
        }

        questionText.startAnimation(fadeIn)

        answer1.startAnimation(fadeIn)
        answer2.startAnimation(fadeIn)
        answer3.startAnimation(fadeIn)
        answer4.startAnimation(fadeIn)

        questionImage.startAnimation(fadeIn)
    }

    private fun setAnswerClick(button: Button, index: Int) {

        button.setOnClickListener {

            val correctIndex =
                questions[currentQuestionIndex].correctAnswer

            val buttons = listOf(
                answer1,
                answer2,
                answer3,
                answer4
            )

            for (btn in buttons) {
                btn.isEnabled = false
            }

            buttons[correctIndex]
                .backgroundTintList =
                android.content.res.ColorStateList.valueOf(
                    Color.parseColor("#22C55E")
                )

            if (index != correctIndex) {

                button.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(
                        Color.parseColor("#EF4444")
                    )

            } else {

                score++
            }

            Handler(Looper.getMainLooper()).postDelayed({

                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {

                    loadQuestion()

                } else {

                    val intent =
                        Intent(this, ResultActivity::class.java)

                    intent.putExtra("score", score)

                    intent.putExtra(
                        "total",
                        questions.size
                    )

                    startActivity(intent)

                    finish()
                }

            }, 1200)
        }
    }

    private fun resetButtonStyles() {

        val defaultColor =
            Color.parseColor("#1E293B")

        answer1.backgroundTintList =
            android.content.res.ColorStateList.valueOf(defaultColor)

        answer2.backgroundTintList =
            android.content.res.ColorStateList.valueOf(defaultColor)

        answer3.backgroundTintList =
            android.content.res.ColorStateList.valueOf(defaultColor)

        answer4.backgroundTintList =
            android.content.res.ColorStateList.valueOf(defaultColor)

        answer1.isEnabled = true
        answer2.isEnabled = true
        answer3.isEnabled = true
        answer4.isEnabled = true
    }
}