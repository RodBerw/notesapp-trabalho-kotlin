package br.edu.up.app.ui.note

import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.app.data.Note
import br.edu.up.app.data.NoteRepository
import br.edu.up.app.data.NoteRepositoryFirebase
import br.edu.up.app.data.NoteRepositorySQLite
import com.google.firebase.firestore.CollectionReference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel
    //Faz a injeção de dependências usando a interface NoteRepository
    @Inject constructor(val repository: NoteRepositorySQLite, val remoteRepository: NoteRepositoryFirebase, private val notesRef: CollectionReference
    ) : ViewModel() {

    var note: Note = Note()

    private var _notes = MutableStateFlow(listOf<Note>())
    val newNotes = MutableStateFlow(listOf<Note>())
    val notes : Flow<List<Note>> = _notes


    private val noteAdded: MutableLiveData<Note?> = remoteRepository.noteAdded

    //Da launch na viewmodel
    init {
        viewModelScope.launch {
            //Observa constantemente o valor da lista notes fornecido pelo repositório,
            // e reaje sempre que atualizado


            repository.notes.collect{ notes ->
                _notes.value = notes
            }



            ConnectivityManager.OnNetworkActiveListener {
                save()
            }

//            remoteRepository.noteAdded.observeForever { newNote ->
//                if (newNote != null) {
//                    note = newNote
//                    print(newNote)
//                    save()
//                }
//            }
        }
        viewModelScope.launch {
            remoteRepository.notes.collect { remoteNotes ->
                val localNotes = _notes.value ?: emptyList()
                val newRemoteNotes = remoteNotes.filter { remoteNote ->
                    localNotes.none { localNote -> localNote.docId == remoteNote.docId }
                }

                newRemoteNotes.forEach { newNote ->
                    if (!localNotes.any { it.docId == newNote.docId }) {
                        repository.save(newNote)
                    }
                }
            }
        }
    }

    fun new(){
        this.note = Note()
    }

    fun edit(note: Note){
        this.note = note
    }

    fun save() = viewModelScope.launch {
        try{
            if(note.docId == null){
                val doc = notesRef.document()
                note.docId = doc.id;
            }
            remoteRepository.save(note)
        }catch (ex: Exception){
            print(ex)
        }
        repository.save(note)

    }

    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
        try{
            remoteRepository.delete(note)
        }catch (ex: Exception){
            print(ex)
        }
    }
}





