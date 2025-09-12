package com.example.corrutinas.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
    var countTime by mutableStateOf(0)
    private set

    private var oneCount by mutableStateOf(false)

    fun fetchData(){

        val job = viewModelScope.launch {

            for(i in 1..5){
                delay(1000)
                countTime = i
            }
            oneCount = true
        }

        if(oneCount){
            job.cancel()
            oneCount = false
        }
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta Obtenida por la Web"
        }
    }
}