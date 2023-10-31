package br.edu.up.app.data

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NoteRepositoryFirebase
    @Inject constructor(private val notesRef: CollectionReference)
    : NoteRepository {

    private var _notes = MutableStateFlow(listOf<Note>())
    override val notes: Flow<List<Note>>
                get() = _notes.asStateFlow()

    init {
        notesRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null){
                var notes = mutableListOf<Note>()
                snapshot.documents.forEach { doc ->
                    val note = doc.toObject<Note>()
                    if (note != null){
                        note.docId = doc.id
                        notes.add(note)
                    }
                }
                _notes.value = notes
            } else {
                _notes = MutableStateFlow(listOf())
            }
        }
    }


    override suspend fun save(note: Note) {
        if (note.docId.isNullOrEmpty()){
            var doc = notesRef.document()
            note.docId = doc.id
            doc.set(note)
        } else {
            notesRef.document(note.docId).set(note)
        }
    }

    override suspend fun delete(note: Note) {
       notesRef.document(note.docId).delete()
    }
}