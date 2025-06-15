package com.example.vinheriaagnello.database.repository

import android.content.Context
import com.example.vinheriaagnello.database.dao.ProdutoDb
import com.example.vinheriaagnello.model.Produto

class ProdutoRepository(context: Context){

    var db = ProdutoDb.getDatabase(context).produtoDao()

    fun salvar(produto: Produto): Long{
        return db.inserir(produto = produto)
    }

    fun atualizar(produto: Produto): Int{
        return db.atualizar(produto = produto)
    }

    fun excluir(produto: Produto): Int{
        return db.deletar(produto = produto)
    }

    fun buscaVinhoPorId(id: Long): Produto{
        return db.buscaVinhoPeloId(id = id)
    }

    fun listarContatos(): List<Produto>{
        return db.listarTodos()
    }

}