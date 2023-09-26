package br.edu.up.app.ui.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.edu.up.app.R
import br.edu.up.app.data.BancoSQLite
import br.edu.up.app.data.ProdutoRepository
import br.edu.up.app.databinding.FragmentProdutoBinding

class ProdutoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val banco = BancoSQLite.get(requireContext())
        val repository = ProdutoRepository(banco.produtoDao())
        val viewModel = ProdutoViewModel(repository)
        val binding = FragmentProdutoBinding.inflate(layoutInflater)

        //binding.inputNome.text = viewModel.produto.nome
        binding.btnSalvar.setOnClickListener {
            viewModel.produto.nome = binding.inputNome.text.toString()
            viewModel.produto.descricao = binding.inputDesc.text.toString()
            viewModel.produto.preco = binding.inputPreco.text.toString().toDouble()
            viewModel.produto.peso = binding.inputPeso.text.toString().toInt()
            viewModel.produto.foto = binding.inputFoto.text.toString()
            viewModel.salvar()
            findNavController().popBackStack()
        }
        return binding.root
    }
}