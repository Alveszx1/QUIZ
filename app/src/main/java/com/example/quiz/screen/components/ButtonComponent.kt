package com.example.quiz.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun QuestionButton(texto: String, respostaCorreta : Boolean, mostrarResultado : Boolean) {
    var cor by remember { mutableStateOf(Color.Transparent) }

    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {
            cor = if (respostaCorreta) Color.Green else Color.Red
        } ,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (!mostrarResultado) {
                Color.Transparent
            } else if (respostaCorreta) {
                Color.Green
            } else {
                Color.Red
            }
                )

    ) {
        Text(text = texto)
    }
}