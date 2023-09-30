package br.edu.up.app

import android.app.Application
import br.edu.up.app.data.BancoSQLite
import br.edu.up.app.data.ProdutoRepository
import br.edu.up.app.ui.produto.ProdutoViewModel

class AppCardapio : Application() {

    lateinit var viewModel: ProdutoViewModel

    override fun onCreate() {
        super.onCreate()
        val banco = BancoSQLite.get(applicationContext)
        val repository = ProdutoRepository(banco.produtoDao())
        viewModel = ProdutoViewModel(repository)
    }
}