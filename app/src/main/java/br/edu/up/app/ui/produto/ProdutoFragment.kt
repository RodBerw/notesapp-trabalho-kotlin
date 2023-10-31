package br.edu.up.app.ui.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.edu.up.app.databinding.FragmentProdutoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProdutoFragment : Fragment() {

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

        val binding = FragmentProdutoBinding.inflate(layoutInflater)

        var produto = viewModel.note
        binding.inputNome.setText(produto.nome)
        binding.inputDesc.setText(produto.descricao)
        binding.inputPreco.setText(produto.preco.toString())
        binding.inputPeso.setText(produto.peso.toString())
        binding.inputFoto.setText(produto.foto.toString())

        binding.btnSalvar.setOnClickListener {
            try {
                viewModel.note.nome = binding.inputNome.text.toString()
                viewModel.note.descricao = binding.inputDesc.text.toString()
                viewModel.note.preco = binding.inputPreco.text.toString().toDouble()
                viewModel.note.peso = binding.inputPeso.text.toString().toInt()
                viewModel.note.foto = binding.inputFoto.text.toString()
                viewModel.note.categoria = 0
            } catch (e: Exception){
            }
            viewModel.salvar()
            findNavController().popBackStack()
        }
        return binding.root
    }
}