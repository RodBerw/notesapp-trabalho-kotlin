package br.edu.up.app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("select * from notes")
    fun list(): Flow<List<Note>>
    @Insert
    suspend fun insert(note: Note)
    @Update
    suspend fun edit(note: Note)
    @Delete
    suspend fun delete(note: Note)
    @Query("delete from notes where id = :id ")
    suspend fun delete(id: Int)
    @Query("delete from notes")
    suspend fun deleteAll()

}