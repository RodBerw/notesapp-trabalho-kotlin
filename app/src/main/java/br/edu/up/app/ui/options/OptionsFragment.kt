package br.edu.up.app.ui.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.edu.up.app.databinding.FragmentOptionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OptionsFragment : Fragment() {

    private var _binding: FragmentOptionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel : OptionsViewModel by activityViewModels()

        _binding = FragmentOptionsBinding.inflate(inflater, container, false)

        var sbFontSize: SeekBar = binding.sbFontSize
        var postItImgName: String = view?.findViewById<RadioButton>(binding.rgColors.checkedRadioButtonId)?.text.toString()


        sbFontSize.addOnLayoutChangeListener{ view: View, i: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int, i7: Int ->
            viewModel.fontSize = sbFontSize.progress.toFloat()
            binding.textNotationEx.textSize = viewModel.fontSize
        }



        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}