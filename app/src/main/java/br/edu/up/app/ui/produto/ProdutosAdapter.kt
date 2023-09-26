package br.edu.up.app.ui.produto

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import br.edu.up.app.data.Fotos
import br.edu.up.app.data.Produto
import br.edu.up.app.databinding.FragmentItemProdutoBinding
import java.text.DecimalFormat
import java.util.Locale

class ProdutosAdapter(
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ProdutosAdapter.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ProdutoViewHolder {

        return ProdutoViewHolder(
            FragmentItemProdutoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        val imgId = Fotos.get(produto.foto)
        holder.imgFoto.setImageResource(imgId)
        holder.txtNome.text = produto.nome
        val localBrasil = Locale("pt", "BR")
        val df = DecimalFormat.getCurrencyInstance(localBrasil)
        holder.txtPreco.text = "${df.format(produto.preco)}"

        holder.itemView.setOnClickListener { view ->
            val action = ProdutosFragmentDirections.actionListaToProduto()
            view.findNavController().navigate(action)
        }

//        holder.itemView.setOnLongClickListener { view ->
//
//
//        }

    }

    override fun getItemCount(): Int = produtos.size

    inner class ProdutoViewHolder(binding: FragmentItemProdutoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgFoto: ImageView = binding.imgFoto
        val txtNome: TextView = binding.txtNome
        val txtPreco: TextView = binding.txtPreco
    }

}