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

    // Botones de colores disponibles
    enum class ColorButton(val color: Color, val label: String, val value: Int) {
        VERDE(Color.Green, "Verde", 1),
        ROJO(Color.Red, "Rojo", 2),
        AMARILLO(Color.Yellow, "Amarillo", 3),
        AZUL(Color.Blue, "Azul", 4)
    }
    /**
     * Data class para definir las propiedades de cada botón.
     */
    data class ButtonData(val colorButton: ColorButton, val shape: RoundedCornerShape)
}