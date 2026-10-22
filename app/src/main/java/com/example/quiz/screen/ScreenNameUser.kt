
    package com.example.quiz.screen

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
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.OutlinedTextField
    import androidx.compose.material3.OutlinedTextFieldDefaults
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.livedata.observeAsState
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController
    import com.example.quiz.R

    @Composable
    fun ScreenName(
        modifier: Modifier = Modifier,
        navController: NavController,
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color(255, 0, 100, 255)),
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

                Card(
                    modifier = Modifier.width(320.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Digite seu nome",
                            fontSize = 22.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = nome.value,
                            onValueChange = {
                                quizViewModel.onNomeChanged(it)
                            },
                            modifier = Modifier.border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(4.dp)
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0, 188, 212, 255),
                                unfocusedBorderColor = Color(0, 188, 212, 255),
                                focusedLabelColor = Color(0, 188, 212, 255),
                                cursorColor = Color(0, 188, 212, 255)
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(219, 59, 255, 255)
                            ),
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color.Black
                            ),
                            onClick = {
                                if (nome.value.isNotBlank()) {
                                    navController.navigate("question")
                                }
                            }
                        ) {
                            Text("Continuar")
                        }
                    }
                }
            }
        }
    }
