package br.edu.up.app.data

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.up.app.ui.note.NoteViewModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ktx.toObject
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class NoteRepositoryFirebase
    @Inject constructor(private val notesRef: CollectionReference)
    : NoteRepository {

    private var _notes = MutableStateFlow(listOf<Note>())
    override val notes: Flow<List<Note>>
                get() = _notes.asStateFlow()


    private val _noteAdded = MutableLiveData<Note?>()

    val noteAdded: MutableLiveData<Note?>
        get() = _noteAdded

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

//                //Atualiza o repositório local quando o remote foi alterado
                for (doc in snapshot.documentChanges) {
                    if (doc.type == DocumentChange.Type.ADDED) {
                        // Um novo documento foi adicionado
                        val newNote = doc.document.toObject<Note>().apply {
                            docId = doc.document.id
                        }
                        _noteAdded.postValue(newNote)
                        notes.add(newNote)
                    }
                    // Adicione lógica para atualizar o banco de dados local para outras mudanças (update ou delete)
                }
                _notes.value = notes
            } else {
                //_notes = MutableStateFlow(listOf())
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