package br.edu.up.app.data

import kotlinx.coroutines.flow.Flow

interface ProdutoRepository {

    val produtos: Flow<List<Produto>>
    suspend fun salvar(produto: Produto)
    suspend fun excluir(produto: Produto)
}