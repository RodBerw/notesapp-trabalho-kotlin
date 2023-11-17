package br.edu.up.app.ui.note

import android.net.ConnectivityManager
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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel
    //Faz a injeção de dependências usando a interface NoteRepository
    @Inject constructor(val repository: NoteRepositorySQLite, val remoteRepository: NoteRepositoryFirebase, private val notesRef: CollectionReference
    ) : ViewModel() {

    var note: Note = Note()

    private var _notes = MutableStateFlow(listOf<Note>())
    val notes : Flow<List<Note>> = _notes

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





