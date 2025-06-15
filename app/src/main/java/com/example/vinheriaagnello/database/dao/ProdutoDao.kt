package com.example.vinheriaagnello.database.dao

import androidx.room.*
import com.example.vinheriaagnello.model.Produto

@Dao
interface ProdutoDao {
    @Insert
    fun inserir(produto: Produto): Long

    @Update
    fun atualizar(produto: Produto): Int

    @Delete
    fun deletar(produto: Produto): Int

    @Query("SELECT * FROM tb_produto WHERE id = :id")
    fun buscaVinhoPeloId(id: Long): Produto

    @Query("SELECT * FROM tb_produto ORDER BY nome ASC")
    fun listarTodos(): List<Produto>
}