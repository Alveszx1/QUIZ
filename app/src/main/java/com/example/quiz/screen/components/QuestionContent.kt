package com.example.quiz.screen.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R

@Composable
fun QuestionContent(
    numeroQuestao: Int,
    pergunta: String,
    alternativas: List<String>,
    respostaCorreta: String,
    onResposta: (Boolean) -> Unit
) {
    var respondeu by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 87, 142, 255))
            .padding(top = 60.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(R.drawable.quiz),
                contentDescription = "Logo do Quiz"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Pergunta $numeroQuestao de 3",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Cyan)
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(16.dp)
                    )
                    .padding(
                        horizontal = 24.dp,
                        vertical = 12.dp
                    )
                    .width(170.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier.width(350.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF9F6F6)
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = pergunta,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    alternativas.forEach { alternativa ->
                        QuestionButton(
                            texto = alternativa,
                            respostaCorreta =
                                alternativa == respostaCorreta,
                            bloqueado = respondeu
                        ) { acertou ->
                            respondeu = true
                            onResposta(acertou)
                        }
                    }
                }
            }
        }
    }
}
