package com.example.quiz.screen



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


import com.example.quiz.screen.components.QuestionContent

@Composable
fun QuestionScreen(
    navController: NavController,
    modifier: Modifier
) {
    QuestionContent(
        numeroQuestao = 1,
        pergunta = "Qual a capital da França?",
        alternativas = listOf(
            "Paris",
            "Berlim",
            "Sidney",
            "Hong-Kong"
        ),
        respostaCorreta = "Paris",
        onResposta = { acertou ->

            val acertos = if (acertou) 1 else 0

            navController.navigate("pergunta2/$acertos")
        }
    )
}

