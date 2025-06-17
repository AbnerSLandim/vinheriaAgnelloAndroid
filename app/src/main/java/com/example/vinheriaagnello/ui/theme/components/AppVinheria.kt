package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*


@Composable
fun AppVinheria() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { navController.navigate("visualizar") }) {
                    Icon(Icons.Filled.Visibility, contentDescription = "Visualizar")
                }
                IconButton(onClick = { navController.navigate("excluir") }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Excluir")
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("adicionar") }) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar")
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "visualizar",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("visualizar") { VisualizarScreen() }
            composable("adicionar") { AdicionarScreen() }
            composable("excluir") { ExcluirScreen() }
        }
    }
}
