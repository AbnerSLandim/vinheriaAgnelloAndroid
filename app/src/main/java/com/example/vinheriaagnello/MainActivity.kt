package com.example.vinheriaagnello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.vinheriaagnello.ui.theme.VinheriaAgnelloTheme

import com.example.vinheriaagnello.ui.theme.components.AppVinheria

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VinheriaAgnelloTheme {
                AppVinheria() // <- Essa função tem o Scaffold + Navegação
            }
        }
    }
}

