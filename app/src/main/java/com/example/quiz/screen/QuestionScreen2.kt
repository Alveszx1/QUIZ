package com.example.quiz.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.quiz.screen.components.QuestionContent
import com.example.quiz.screen.components.QuestionContent

@Composable
fun QuestionScreen2(
    navController: NavController,
    acertos: Int
) {
    QuestionContent(
        numeroQuestao = 2,
        pergunta = "Qual é o maior planeta do Sistema Solar?",
        alternativas = listOf(
            "Terra",
            "Marte",
            "Júpiter",
            "Vênus"
        ),
        respostaCorreta = "Júpiter",
        onResposta = { acertou ->
            val totalAcertos = acertos + if (acertou) 1 else 0

            navController.navigate("pergunta3/$totalAcertos")
        }
    )
}
