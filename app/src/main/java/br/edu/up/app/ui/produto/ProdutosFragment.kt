package br.edu.up.app.ui.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.edu.up.app.databinding.FragmentListProdutosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProdutosFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val banco = BancoSQLite.get(requireContext())
//        val repository = ProdutoRepository(banco.produtoDao())
//        val viewModel = ProdutoViewModel(repository)

//        val context = requireActivity().applicationContext
//        val viewModel = (context as AppCardapio).viewModel

        val viewModel : ProdutoViewModel by activityViewModels()

        val binding = FragmentListProdutosBinding.inflate(layoutInflater)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.produtos.collect{ produtos ->
                    if (binding.root is RecyclerView) {
                        val recyclerView = binding.root
                        with(recyclerView) {
                            layoutManager = LinearLayoutManager(context)
                            adapter = ProdutosAdapter(produtos,viewModel)
                        }
                    }
                }
            }

        }
        return binding.root
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ProdutosFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}