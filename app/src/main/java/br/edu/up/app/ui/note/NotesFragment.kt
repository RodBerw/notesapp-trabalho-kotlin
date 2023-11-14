package br.edu.up.app.ui.note

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.edu.up.app.R
import br.edu.up.app.databinding.FragmentNotesRecyclerBinding
import br.edu.up.app.ui.options.OptionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val banco = BancoSQLite.get(requireContext())
//        val repository = ProdutoRepository(banco.produtoDao())
//        val viewModel = ProdutoViewModel(repository)

//        val context = requireActivity().applicationContext
//        val viewModel = (context as AppCardapio).viewModel

        val viewModel : NoteViewModel by activityViewModels()
        val optionsViewModel: OptionsViewModel by activityViewModels()

        val binding = FragmentNotesRecyclerBinding.inflate(layoutInflater)

        binding.fabAddNotes.setOnClickListener { view ->
            viewModel.new()
            val action = NotesFragmentDirections.actionHomeToNote()
            findNavController().navigate(action)
        }

        binding.fabOptions.setOnClickListener{view ->
            viewModel.new()
            val action = NotesFragmentDirections.actionNavHomeToNavGallery()
            findNavController().navigate(action)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.notes.collect{ notes ->
                    if (binding.rvNotes is RecyclerView) {
                        val recyclerView = binding.rvNotes
                        with(recyclerView) {
                            layoutManager = GridLayoutManager(context, 2)
                            adapter = NotesAdapter(notes,viewModel, optionsViewModel)
                        }
                    }
                }
            }

        }
        return binding.root
    }
//
//    companion object {
//
//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//            NotesFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
//    }
}