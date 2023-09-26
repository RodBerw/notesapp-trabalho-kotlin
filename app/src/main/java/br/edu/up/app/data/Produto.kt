package br.edu.up.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class Produto(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nome: String,
    var descricao: String,
    var preco: Double,
    var peso: Int,
    var foto: String,
    var categoria: Int
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