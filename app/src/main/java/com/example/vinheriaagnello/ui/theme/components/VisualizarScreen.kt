package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vinheriaagnello.viewmodel.ProdutoViewModel

@Composable
fun VisualizarScreen(viewModel: ProdutoViewModel = viewModel()) {
    val produtos by viewModel.produtos.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = "Vinhos cadastrados",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (produtos.isEmpty()) {
            Text("Nenhum vinho cadastrado.")
        } else {
            LazyColumn {
                items(produtos) { produto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { /* Talvez você queira navegar para detalhes ou algo assim */ },
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = produto.nome, style = MaterialTheme.typography.titleMedium)
                            Text(text = produto.descricao, style = MaterialTheme.typography.bodyMedium)
                            Text(text = "R$ %.2f".format(produto.preco), style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
