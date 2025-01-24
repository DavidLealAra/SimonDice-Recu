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
}