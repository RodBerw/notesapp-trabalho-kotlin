package br.edu.up.app.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.edu.up.app.data.Note
import br.edu.up.app.databinding.FragmentEditNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditNoteFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel : NoteViewModel by activityViewModels()

        val binding = FragmentEditNoteBinding.inflate(layoutInflater)

        binding.inputNotation.setText(viewModel.note.notation)

        binding.btnSave.setOnClickListener {
            try {
                //When in this page, the view model Note is already set as the clicked one
                viewModel.note.notation = binding.inputNotation.text.toString()
            } catch (e: Exception){
            }
            viewModel.save()
            findNavController().popBackStack()
        }

        return binding.root
    }
}