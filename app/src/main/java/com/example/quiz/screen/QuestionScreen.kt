package com.example.quiz.screen



import android.R.attr.padding
import android.R.attr.strokeColor
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.navigation.NavController
import com.example.quiz.R
import com.example.quiz.screen.components.QuestionButton

@Composable
fun QuestionScreen(modifier: Modifier = Modifier, navController: NavController) {
    var mostrarResultado by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(255, 87, 142, 255))
            .padding(0.dp,60.dp,0.dp,0.dp)
        ,
        contentAlignment = Alignment.TopCenter

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(R.drawable.quiz),
                contentDescription = "Logo do Quiz"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Pergunta 1 de 3",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(0, 255, 255, 255))
                    .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                    .padding(horizontal = 24.dp, vertical = 12.dp)
                    .width(170.dp),
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
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Qual a capital da França",
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    QuestionButton(texto = "França", true, mostrarResultado)
                    QuestionButton(texto = "França", false,mostrarResultado)
                    QuestionButton(texto = "França",false,mostrarResultado)
                    QuestionButton(texto = "França",false,mostrarResultado)

                }
            }


        }
    }
}
