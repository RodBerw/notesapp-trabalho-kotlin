package br.edu.up.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class Produto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val peso: Int,
    val foto: String,
    val categoria: Int
)
{
    constructor():this(
        0,
        "",
        "",
        0.0,
        0,
        "semfoto.jpg",
        0
    )
}