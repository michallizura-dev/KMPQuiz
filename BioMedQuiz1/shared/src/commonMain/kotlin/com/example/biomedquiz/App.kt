package com.example.biomedquiz

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App() {
    val viewModel = remember { QuizViewModel() }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 1. EKRAN WYBORU KATEGORII
                if (viewModel.currentCategory == null) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Wybierz kategorię quizu", fontSize = 26.sp, modifier = Modifier.padding(bottom = 32.dp))

                    val categories = listOf("Anatomia i fizjologia", "Biosygnały", "Biomateriały", "Aparatura medyczna")

                    categories.forEach { cat ->
                        Button(
                            onClick = { viewModel.startQuiz(cat) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            Text(text = cat, fontSize = 18.sp)
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
                // 2. EKRAN KOŃCOWY
                else if (viewModel.isQuizFinished) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Koniec quizu!", fontSize = 28.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Twój wynik: ${viewModel.score} / ${viewModel.getTotalQuestionsCount()}", fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(24.dp))

                    Button(onClick = { viewModel.returnToCategorySelection() }) {
                        Text(text = "Wybierz inną kategorię")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
                // 3. EKRAN PYTAŃ (Aktywny quiz)
                else if (viewModel.currentQuestion != null) {
                    val question = viewModel.currentQuestion!!

                    // -- LICZNIK NA SAMEJ GÓRZE --
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Pytanie ${viewModel.getCurrentQuestionNumber()} z ${viewModel.getTotalQuestionsCount()}",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Punkty: ${viewModel.score}",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Treść pytania
                    Text(
                        text = question.question,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                    )

                    // Odpowiedzi
                    question.answers.forEachIndexed { index, answer ->
                        val isSelected = viewModel.selectedAnswerIndex == index
                        val isCorrect = viewModel.correctAnswerIndex == index

                        val buttonColor = when {
                            viewModel.correctAnswerIndex != null && isCorrect -> Color(0xFF4CAF50) // Zielony
                            viewModel.correctAnswerIndex != null && isSelected && !isCorrect -> Color(0xFFE53935) // Czerwony
                            else -> ButtonDefaults.buttonColors().containerColor
                        }

                        Button(
                            onClick = {
                                if (viewModel.selectedAnswerIndex == null) {
                                    viewModel.selectAnswer(index)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Text(text = answer, fontSize = 16.sp, color = Color.White)
                        }
                    }

                    // -- PRZYCISK "NASTĘPNE PYTANIE" (nieco wyżej, zaraz pod odpowiedziami) --
                    if (viewModel.selectedAnswerIndex != null) {
                        Spacer(modifier = Modifier.height(24.dp))
                        Button(
                            onClick = { viewModel.moveToNextQuestion() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Następne pytanie", fontSize = 16.sp)
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Ładowanie pytań...")
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}