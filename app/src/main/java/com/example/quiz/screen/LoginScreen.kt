
package com.example.quiz.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0, 188, 212, 255)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(110.dp),
                painter = painterResource(R.drawable.quiz),
                contentDescription = "Logo do Quiz"
            )

            Spacer(Modifier.height(60.dp))

            Text(
                text = "QUIZATRON 3000",
                fontSize = 32.sp
            )

            Spacer(Modifier.height(30.dp))

            Button(modifier = Modifier.width(220.dp),
                onClick = {
                    navController.navigate("question")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(255, 235, 59, 255)
                ),
                border = BorderStroke(width = 2.dp, color = Color.Black)
            ) {
                Text(
                    text = "COMEÇAR",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }
}
