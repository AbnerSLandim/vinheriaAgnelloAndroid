package com.example.vinheriaagnello.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinheriaagnello.database.repository.ProdutoRepository
import com.example.vinheriaagnello.model.Produto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProdutoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProdutoRepository(application)

    private val _produtos = MutableStateFlow<List<Produto>>(emptyList())
    val produtos: StateFlow<List<Produto>> = _produtos

    var nome = ""
    var descricao = ""
    var preco = ""

    init {
        carregarProdutos()
    }

    fun carregarProdutos() {
        viewModelScope.launch {
            _produtos.value = repository.listarContatos()
        }
    }

    fun salvarProduto() {
        viewModelScope.launch {
            val novoProduto = Produto(
                nome = nome,
                descricao = descricao,
                preco = preco.toDoubleOrNull() ?: 0.0
            )
            repository.salvar(novoProduto)
            carregarProdutos()
        }
    }

    fun deletarProduto(produto: Produto) {
        viewModelScope.launch {
            repository.excluir(produto)
            carregarProdutos()
        }
    }
}
