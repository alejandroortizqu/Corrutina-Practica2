package com.example.corrutinas.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
    private set

    fun bloqueApp(){
        Thread.sleep(5000)
        resultState = "Resultado de la web"
    }
}