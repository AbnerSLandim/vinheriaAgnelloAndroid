package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.ui.Alignment

@Composable
fun AppVinheria() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val iconBackgroundColor = Color(0xFF9C0009)

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomAppBar(
                tonalElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Visualizar
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(iconBackgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { navController.navigate("visualizar") }) {
                            Icon(
                                Icons.Default.Visibility,
                                contentDescription = "Visualizar",
                                tint = Color.White
                            )
                        }
                    }

                    // Adicionar
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(iconBackgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { navController.navigate("adicionar") }) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Adicionar",
                                tint = Color.White
                            )
                        }
                    }

                    // Excluir
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(iconBackgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { navController.navigate("excluir") }) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Excluir",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "adicionar",
            modifier = Modifier.padding(padding)
        ) {
            composable("visualizar") { VisualizarScreen() }
            composable("adicionar") { AdicionarScreen() }
            composable("excluir") { ExcluirScreen() }
        }
    }
}
