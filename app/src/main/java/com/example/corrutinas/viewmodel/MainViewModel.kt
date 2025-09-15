package com.example.corrutinas.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
    var countTime by mutableStateOf(0)
    private set
    var oneCount by mutableStateOf(false)


    fun contadorDoble(){
        resultState = ""
        oneCount = true
        viewModelScope.launch {
            for(i in 1..5){
                delay(1000)
                countTime = i
            }
            countTime = 0
            for(i in 1..5){
                delay(1000)
                countTime = i
            }
            oneCount = false
        }
        viewModelScope.launch {
            delay(10000)
            resultState = "Fin de Contadores"
        }
    }
    fun cancelarContador() {
        viewModelScope.coroutineContext.cancelChildren()
        countTime = 0
        oneCount = false
        resultState = "Contador cancelado"
    }
}