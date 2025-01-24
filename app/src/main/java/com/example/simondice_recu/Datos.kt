package com.example.simondice_recu

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color

object Datos {

    // Estados posibles del juego
    enum class Estados(val value: Int, val label: String) {
        INICIO(0, "Inicio"),
        GENERANDO(1, "Generando"),
        ADIVINANDO(2, "Adivinando"),
        PERDIDO(3, "Perdido")
    }
}