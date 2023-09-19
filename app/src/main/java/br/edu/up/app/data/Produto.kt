package br.edu.up.app.data

data class Produto(
    val codigo: Int,
    val nome: String,
    val descricao: String = String(),
    val preco: Double = 0.0,
    val peso: Int = 0,
    val foto: String = "semfoto.jpg",
    val categoria: Int = 0
)