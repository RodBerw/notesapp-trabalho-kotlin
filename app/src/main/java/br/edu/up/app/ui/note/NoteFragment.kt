package br.edu.up.app.ui.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.edu.up.app.data.Note
import br.edu.up.app.databinding.FragmentCreateNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.count

@AndroidEntryPoint
class NoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel : NoteViewModel by activityViewModels()

        val binding = FragmentCreateNoteBinding.inflate(layoutInflater)

//        var note = viewModel.note
//        binding.inputNotation.setText(note.notation)

        binding.btnSave.setOnClickListener {
            try {
                val note: Note = Note()
                note.notation = binding.inputNotation.text.toString()

                viewModel.note = note;
            } catch (e: Exception){
            }
            viewModel.save()
            findNavController().popBackStack()
        }
        return binding.root
    }
}