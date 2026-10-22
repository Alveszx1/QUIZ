package com.example.quiz.screen.components

import androidx.compose.foundation.BorderStroke
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
fun QuestionButton(
    texto: String,
    respostaCorreta: Boolean,
    bloqueado: Boolean,
    onResposta: (Boolean) -> Unit
) {
    var corFundo by remember {
        mutableStateOf(Color.White)
    }

    var corResultado by remember {
        mutableStateOf(Color.Gray)
    }

    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp),

        enabled = !bloqueado,

        shape = RoundedCornerShape(10.dp),

        onClick = {
            if (!bloqueado) {
                if (respostaCorreta) {
                    corFundo = Color(0xFFC8E6C9)
                    corResultado = Color(0xFF1B5E20)
                } else {
                    corFundo = Color(0xFFFFCDD2)
                    corResultado = Color(0xFFB71C1C)
                }
                onResposta(respostaCorreta)
            }
        },

        border = BorderStroke(2.dp, corResultado),

        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = corFundo,
            contentColor = corResultado,
            disabledContainerColor = corFundo,
            disabledContentColor = corResultado
        )
    ) {
        Text(
            text = texto,
            color = corResultado
        )
    }
}
