package br.edu.up.app.ui.produto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.up.app.R

class ProdutoFragment : Fragment() {

    companion object {
        fun newInstance() = ProdutoFragment()
    }

    private lateinit var viewModel: ProdutoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_produto, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProdutoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}