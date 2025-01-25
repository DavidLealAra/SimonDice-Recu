package com.example.simondice_recu

import android.media.MediaPlayer
import androidx.activity.ComponentActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * ViewModel que gestiona el estado y la lógica del juego "Simón Dice".
 */
class ModelView(private val activity: ComponentActivity) : ViewModel() {

    // LiveData para el estado del juego
    val estadoLiveData = MutableLiveData(Datos.Estados.INICIO)

    // LiveData para la ronda actual
    val rondaLiveData = MutableLiveData(0)

    // LiveData para gestionar los mensajes
    val mensajeLiveData = MutableLiveData<String>()
    // Secuencia de colores que el usuario debe recordar
    private val secuenciaColores = mutableListOf<Datos.ColorButton>()
    // Índice actual del color que el usuario está adivinando
    private var indiceActual = 0
    /**
     * Comienza el juego reiniciando todos los valores y generando la primera secuencia.
     */
    fun empezarJuego() {
        estadoLiveData.value = Datos.Estados.GENERANDO
        secuenciaColores.clear()
        rondaLiveData.value = 0
    }
    /**
     * Finaliza el juego cambiando el estado a PERDIDO.
     */
    fun finalizarJuego() {
        estadoLiveData.value = Datos.Estados.PERDIDO
        mensajeLiveData.postValue("Perdiste")
    }
    /**
     * Muestra la secuencia al usuario.
     * Cambia el estado a ADIVINANDO una vez que se muestra completamente.
     */
    private fun mostrarSecuencia() {
        viewModelScope.launch {
            for (color in secuenciaColores) {
                mensajeLiveData.postValue(color.label)
                delay(500)
                mensajeLiveData.postValue("")
                delay(500)
            }
            estadoLiveData.value = Datos.Estados.ADIVINANDO
            indiceActual = 0
        }
    }
    /**
     * Compara el color seleccionado por el usuario con el esperado en la secuencia.
     */
    fun compararColor(colorSeleccionado: Datos.ColorButton): Boolean {
        if (colorSeleccionado == secuenciaColores[indiceActual]) {
            indiceActual++
            if (indiceActual == secuenciaColores.size) {
                estadoLiveData.value = Datos.Estados.GENERANDO
                viewModelScope.launch {
                    delay(1000)
                }
            }
            return true
        } else {
            finalizarJuego()
            return false
        }
    }
}