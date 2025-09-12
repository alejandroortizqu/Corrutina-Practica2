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

    fun fetchData(){
        viewModelScope.launch {
            for(i in 1..5){
                delay(1000)
                countTime = i
            }
        }
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta Obtenida por la Web"
        }
    }
}