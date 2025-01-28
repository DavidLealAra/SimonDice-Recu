package com.example.simondice_recu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IU(viewModel: ModelView) {
    val estado by viewModel.estadoLiveData.observeAsState(Datos.Estados.INICIO)
    val ronda by viewModel.rondaLiveData.observeAsState(0)
    val mensaje by viewModel.mensajeLiveData.observeAsState("")

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Black)
    ) {
        Text(text = "Ronda: $ronda", color = Color.Green, modifier = Modifier.padding(16.dp))

        if (estado == Datos.Estados.PERDIDO) {
            Text(text = "Perdiste", color = Color.Red, modifier = Modifier.padding(16.dp))
        }

        Botones(viewModel, estado, mensaje)
        BotonInicio(viewModel, estado)
    }
}
    /**
     * BotonInicio - Renderiza el botón para iniciar el juego.
     */
    @Composable
    fun BotonInicio(viewModel: ModelView, estado: Datos.Estados) {
        Button(
            onClick = { viewModel.empezarJuego() },
            modifier = Modifier.padding(8.dp),
            enabled = estado == Datos.Estados.INICIO || estado == Datos.Estados.PERDIDO
        ) {
            Text("Iniciar")
        }
    }

    /**
     * Botones - Renderiza los botones de colores.
     */
/**
 * Botones - Renderiza los botones de colores.
 */
@Composable
fun Botones(viewModel: ModelView, estado: Datos.Estados, mensaje: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        viewModel.buttons.chunked(2).forEach { fila ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                fila.forEach { boton ->
                    Button(
                        onClick = {
                            if (estado == Datos.Estados.ADIVINANDO) {
                                viewModel.compararColor(boton.colorButton)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (mensaje == boton.colorButton.label) boton.colorButton.color.copy(alpha = 0.7f) else boton.colorButton.color
                        ),
                        modifier = Modifier
                            .size(120.dp)
                            .padding(4.dp),
                        shape = boton.shape
                    ) {}
                }
            }
        }
    }
}

