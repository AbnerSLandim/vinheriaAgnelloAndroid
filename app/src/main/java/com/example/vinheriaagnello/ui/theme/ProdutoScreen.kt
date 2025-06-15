package com.example.vinheriaagnello.ui

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
fun ProdutoScreen(viewModel: ProdutoViewModel = viewModel()) {
    val produtos by viewModel.produtos.collectAsState()

    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = nome,
            onValueChange = {
                nome = it
                viewModel.nome = it
            },
            label = { Text("Nome do vinho") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = {
                descricao = it
                viewModel.descricao = it
            },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = preco,
            onValueChange = {
                preco = it
                viewModel.preco = it
            },
            label = { Text("Preço") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                viewModel.salvarProduto()
                nome = ""
                descricao = ""
                preco = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar vinho")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Lista de vinhos:", style = MaterialTheme.typography.titleMedium)

        LazyColumn {
            items(produtos) { produto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { viewModel.deletarProduto(produto) }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = produto.nome, style = MaterialTheme.typography.titleSmall)
                        Text(text = produto.descricao)
                        Text(text = "R$ %.2f".format(produto.preco))
                    }
                }
            }
        }
    }
}
