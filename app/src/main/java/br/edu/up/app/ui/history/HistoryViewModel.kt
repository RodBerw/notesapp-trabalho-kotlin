package br.edu.up.app.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.app.data.Note
import br.edu.up.app.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel
    @Inject constructor(val repository: NoteRepository) : ViewModel(){
        var note : Note = Note()

        private var _notes = MutableStateFlow(listOf<Note>())
        val notes : Flow<List<Note>> = _notes


        fun save() = viewModelScope.launch{
            repository.save(note);
        }
    }



