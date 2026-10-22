package com.example.quiz.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.quiz.screen.components.QuestionContent

@Composable
fun QuestionScreen3(
    navController: NavController,
    acertos: Int,
    nome: String
) {
    QuestionContent(
        numeroQuestao = 3,
        pergunta = "Qual e a Capital do Brasil",
        alternativas = listOf(
            "São Paulo",
            "Rio de Janeiro",
            "Salvador",
            "Brasilia"
        ),
        respostaCorreta = "Brasilia",

        onResposta = { acertou ->
            val totalAcertos = acertos + if (acertou) 1 else 0

            navController.navigate("result/$nome/$totalAcertos")
        }
    )
}
