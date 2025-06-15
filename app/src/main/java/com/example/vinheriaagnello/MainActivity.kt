package com.example.vinheriaagnello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vinheriaagnello.ui.theme.VinheriaAgnelloTheme

import androidx.activity.compose.setContent
import com.example.vinheriaagnello.ui.ProdutoScreen
import com.example.vinheriaagnello.ui.theme.VinheriaAgnelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VinheriaAgnelloTheme {
                ProdutoScreen()
            }
        }
    }
}
