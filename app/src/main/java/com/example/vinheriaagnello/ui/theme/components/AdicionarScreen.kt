package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vinheriaagnello.viewmodel.ProdutoViewModel

@Composable
fun AdicionarScreen(viewModel: ProdutoViewModel = viewModel()) {
    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }

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

        OutlinedTextField(
            value = descricao,
            onValueChange = {
                descricao = it
                viewModel.descricao = it
            },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = categoria,
            onValueChange = {
                categoria = it
                viewModel.categoria = it
            },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = marca,
            onValueChange = {
                marca = it
                viewModel.marca = it
            },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

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
                categoria = ""
                marca = ""
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9C0009),
                contentColor = Color.White
            )
        ) {
            Text("Salvar vinho")
        }
    }
}
