package br.edu.up.app.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    val notes: Flow<List<Note>>
    suspend fun save(note: Note)
    suspend fun delete(note: Note)
}