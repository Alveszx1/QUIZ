package com.example.quiz.screen


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionViewModel : ViewModel() {

    private val perguntas = listOf(
        "Qual a capital da França?",
        "Qual a capital da Itália?",
        "Qual a capital de Portugal?"
    )

    private val alternativas = listOf(
        listOf("Paris", "Roma", "Londres", "Madri"),
        listOf("Lisboa", "Roma", "Paris", "Madri"),
        listOf("Londres", "Roma", "Lisboa", "Paris")
    )

    private val _numeroPergunta = MutableLiveData(0)
    val numeroPergunta: LiveData<Int> = _numeroPergunta

    fun obterPergunta(): String {
        return perguntas[_numeroPergunta.value ?: 0]
    }

    fun obterAlternativas(): List<String> {
        return alternativas[_numeroPergunta.value ?: 0]
    }

    fun proximaPergunta() {
        val atual = _numeroPergunta.value ?: 0

        if (atual < 2) {
            _numeroPergunta.value = atual + 1
        }
    }
}