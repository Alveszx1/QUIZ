package com.example.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.screen.LoginScreen
import com.example.quiz.screen.QuestionScreen
import com.example.quiz.screen.QuestionScreen2
import com.example.quiz.screen.QuestionScreen3
import com.example.quiz.screen.Result
import com.example.quiz.screen.ScreenName
import com.example.quiz.ui.theme.QUIZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QUIZTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding),
                                navController = navController)
                        }

                        composable("screenName") {
                            ScreenName(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                            )
                        }

                        composable("question/{nome}") {
                            val nome = it.arguments?.getString("nome") ?: ""

                            QuestionScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                nome = nome
                            )
                        }


                        composable("pergunta2/{nome}/{acertos}") {
                            QuestionScreen2(
                                navController = navController,
                                nome = it.arguments?.getString("nome") ?: "",
                                acertos = it.arguments?.getString("acertos")?.toInt() ?: 0
                            )
                        }

                        composable("pergunta3/{nome}/{acertos}") {
                            QuestionScreen3(
                                navController = navController,
                                nome = it.arguments?.getString("nome") ?: "",
                                acertos = it.arguments?.getString("acertos")?.toInt() ?: 0
                            )
                        }

                        composable("result/{nome}/{acertos}") {
                            Result(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                nome = it.arguments?.getString("nome") ?: "",
                                numeroAcertos = it.arguments?.getString("acertos")?.toInt() ?: 0
                            )
                        }
                    }
                }
            }
        }
    }
}