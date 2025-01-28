package com.example.simondice_recu

import android.media.MediaPlayer
import androidx.activity.ComponentActivity
import androidx.compose.foundation.shape.CircleShape
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

    // Inicialización de botones
    val buttons = listOf(
        Datos.ButtonData(Datos.ColorButton.VERDE, CircleShape),
        Datos.ButtonData(Datos.ColorButton.ROJO, CircleShape),
        Datos.ButtonData(Datos.ColorButton.AMARILLO, CircleShape),
        Datos.ButtonData(Datos.ColorButton.AZUL, CircleShape)
    )
    // Sonidos
    private val soundMap = mapOf(
        Datos.ColorButton.VERDE to MediaPlayer.create(activity, R.raw.sound_green),
        Datos.ColorButton.ROJO to MediaPlayer.create(activity, R.raw.sound_red),
        Datos.ColorButton.AMARILLO to MediaPlayer.create(activity, R.raw.sound_yellow),
        Datos.ColorButton.AZUL to MediaPlayer.create(activity, R.raw.sound_blue),
        "start" to MediaPlayer.create(activity, R.raw.sound_start),
        "error" to MediaPlayer.create(activity, R.raw.sound_error)
    )
    /**
     * Comienza el juego reiniciando todos los valores y generando la primera secuencia.
     */
    fun empezarJuego() {
        estadoLiveData.value = Datos.Estados.GENERANDO
        secuenciaColores.clear()
        rondaLiveData.value = 0
        soundMap["start"]?.start()
        agregarColorASecuencia()
    }
    /**
     * Finaliza el juego cambiando el estado a PERDIDO.
     */
    fun finalizarJuego() {
        estadoLiveData.value = Datos.Estados.PERDIDO
        mensajeLiveData.postValue("Perdiste")
        soundMap["error"]?.start()
    }
    /**
     * Muestra la secuencia al usuario.
     * Cambia el estado a ADIVINANDO una vez que se muestra completamente.
     */
    private fun mostrarSecuencia() {
        viewModelScope.launch {
            for (color in secuenciaColores) {
                mensajeLiveData.postValue(color.label)
                soundMap[color]?.start()
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
                    agregarColorASecuencia()
                }
            }
            return true
        } else {
            finalizarJuego()
            return false
        }
    }
    /**
     * Agrega un nuevo color a la secuencia y actualiza la ronda.
     */
    private fun agregarColorASecuencia() {
        val nuevoColor = Datos.ColorButton.values().random()
        secuenciaColores.add(nuevoColor)
        rondaLiveData.value = (rondaLiveData.value ?: 0) + 1
        mostrarSecuencia()
    }
}