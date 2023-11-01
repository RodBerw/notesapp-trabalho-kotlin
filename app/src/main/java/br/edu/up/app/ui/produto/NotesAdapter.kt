package br.edu.up.app.ui.produto

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import br.edu.up.app.R
import br.edu.up.app.data.Note
import br.edu.up.app.databinding.FragmentNoteBinding
import coil.load
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.DecimalFormat
import java.util.Locale

class NotesAdapter(
    private val notes: List<Note>,
    val viewModel: NoteViewModel
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            NoteViewHolder {

        return NoteViewHolder(
            FragmentNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.txtNotation.text = note.notation

        holder.itemView.setOnClickListener { view ->
            viewModel.edit(note)
            val action = NotesFragmentDirections.actionHomeToNote()
            view.findNavController().navigate(action)
        }

        holder.itemView.setOnLongClickListener { view ->
            AlertDialog.Builder(view.context)
                .setMessage("ATENÇÃO")
                .setPositiveButton("Confirmar") { dialog, id ->
                    viewModel.delete(note)
                }
                .setNegativeButton("CANCELAR") { dialog, id ->
                    //ignorar
                }.create().show()
            true
        }

    }

    override fun getItemCount(): Int = notes.size

    inner class NoteViewHolder(binding: FragmentNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val txtNotation: TextView = binding.txtNotation
    }

}