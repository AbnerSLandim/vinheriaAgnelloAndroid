import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                containerColor = Color(0xFF9C0009), // cor de fundo
                tonalElevation = 4.dp // sombra leve
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Visualizar
                    IconButton(onClick = onVisualizar) {
                        Icon(
                            Icons.Filled.Visibility,
                            contentDescription = "Visualizar",
                            tint = Color.White
                        )
                    }

                    // Adicionar
                    IconButton(onClick = onAdicionar) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Adicionar",
                            tint = Color.White
                        )
                    }

                    // Excluir
                    IconButton(onClick = onExcluir) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Excluir",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        // Conteúdo da tela principal sem padding extra
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), // usa o innerPadding do Scaffold
            contentAlignment = Alignment.Center
        ) {
            Text("Conteúdo da tela", fontSize = 20.sp)
        }
    }
}
