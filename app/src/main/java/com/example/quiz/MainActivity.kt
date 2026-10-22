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
                                navController = navController)}

                        composable(route = "question") {
                            QuestionScreen(modifier = Modifier.padding(innerPadding),
                                navController = navController)
                        }

                        composable("pergunta2/{acertos}") {
                            QuestionScreen2(
                                navController = navController,
                                acertos = it.arguments?.getString("acertos")?.toInt() ?: 0
                            )
                        }
                    }
                }
            }
        }
    }
}