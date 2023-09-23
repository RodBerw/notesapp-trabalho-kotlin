package br.edu.up.app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProdutoDao {

    @Query("select * from produtos")
    fun listar(): Flow<List<Produto>>
    @Insert
    suspend fun inserir(produto: Produto)
    @Update
    suspend fun atualizar(produto: Produto)
    @Delete
    suspend fun excluir(produto: Produto)
    @Query("delete from produtos where id = :id ")
    suspend fun excluir(id: Int)
    @Query("delete from produtos")
    suspend fun excluirTodos()
}