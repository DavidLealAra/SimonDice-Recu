package com.example.simondice_recu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import com.example.simondice_recu.ui.theme.SimonDiceRecuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimonDiceRecuTheme {
                Surface(
                    color = Color.Black,
                    modifier = Modifier.fillMaxSize()
                ) {
                    IU(viewModel = ModelView(this))
                }
            }
        }
    }
}