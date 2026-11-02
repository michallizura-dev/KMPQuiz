package com.example.quiz

data class Question(
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int,
    val category: String,
    val imageResId: Int? = null

)