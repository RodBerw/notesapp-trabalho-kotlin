package br.edu.up.app.ui.note

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import br.edu.up.app.R
import br.edu.up.app.data.Note
import br.edu.up.app.databinding.FragmentNoteBinding
import br.edu.up.app.ui.options.OptionsViewModel


class NotesAdapter(
    private val notes: List<Note>,
    val viewModel: NoteViewModel,
    val optionsViewModel: OptionsViewModel

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
        holder.txtNotation.textSize = optionsViewModel.fontSize

        holder.itemView.setOnClickListener { view ->
            viewModel.edit(note)
            view.findNavController().navigate(R.id.action_nav_home_to_nav_editNote)
        }

        holder.itemView.setOnLongClickListener { view ->
            AlertDialog.Builder(view.context)
                .setMessage("Delete note?")
                .setPositiveButton("Confirm") { dialog, id ->
                    viewModel.delete(note)
                }
                .setNegativeButton("Cancel") { dialog, id ->
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