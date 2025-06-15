package com.example.vinheriaagnello.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_produto")
data class Produto(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String = "",
    val descricao: String = "",
    val imagem: String = "",
    val marca: String = "",
    val categoria: String = "",
    val preco: Double = 0.0
)
