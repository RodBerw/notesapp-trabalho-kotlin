package br.edu.up.app.ui.produto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.app.data.Note
import br.edu.up.app.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProdutoViewModel
    @Inject constructor(val repository: NoteRepository) : ViewModel() {

    var note: Note = Note()

    private var _produtos = MutableStateFlow(listOf<Note>())
    val produtos : Flow<List<Note>> = _produtos

    init {
        viewModelScope.launch {
            repository.produtos.collect{ produtos ->
                _produtos.value = produtos
            }
        }
    }

    fun novo(){
        this.note = Note()
    }

    fun editar(note: Note){
        this.note = note
    }

    fun salvar() = viewModelScope.launch {
        repository.salvar(note)
    }

    fun excluir(note: Note) = viewModelScope.launch {
        repository.excluir(note)
    }
}





