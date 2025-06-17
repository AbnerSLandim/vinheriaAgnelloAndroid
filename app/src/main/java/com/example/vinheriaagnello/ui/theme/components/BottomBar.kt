package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaComBottomAppBar(
    onAdicionar: () -> Unit,
    onExcluir: () -> Unit,
    onVisualizar: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { onVisualizar() }) {
                        Icon(Icons.Filled.Visibility, contentDescription = "Visualizar")
                    }
                    IconButton(onClick = { onExcluir() }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Excluir")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { onAdicionar() }) {
                        Icon(Icons.Filled.Add, contentDescription = "Adicionar")
                    }
                }
            )
        }
    ) { innerPadding ->
        // Conteúdo principal da tela
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Conteúdo da tela", fontSize = 20.sp)
        }
    }
}
