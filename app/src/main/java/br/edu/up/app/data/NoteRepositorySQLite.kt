package br.edu.up.app.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositorySQLite
    @Inject constructor(val notesDao: NotesDao)
    : NoteRepository {

    override val notes: Flow<List<Note>>
    get() = notesDao.list()

    override suspend fun save(note: Note) {
        if (note.id == 0) {
            notesDao.insert(note)
        } else {
            notesDao.edit(note)
        }
    }

    override suspend fun delete(note: Note) {
        notesDao.delete(note)
    }
}