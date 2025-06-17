package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vinheriaagnello.viewmodel.ProdutoViewModel

@Composable
fun ExcluirScreen(viewModel: ProdutoViewModel = viewModel()) {
    val produtos by viewModel.produtos.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = "Excluir Vinhos",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (produtos.isEmpty()) {
            Text("Nenhum vinho para excluir.")
        } else {
            LazyColumn {
                items(produtos) { produto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = produto.nome, style = MaterialTheme.typography.titleMedium)
                                Text(text = produto.descricao, style = MaterialTheme.typography.bodyMedium)
                                Text(text = "R$ %.2f".format(produto.preco), style = MaterialTheme.typography.bodySmall)
                            }

                            IconButton(
                                onClick = { viewModel.deletarProduto(produto) }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Excluir produto",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}