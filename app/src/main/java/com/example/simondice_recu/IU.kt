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
    Column {

    }
}