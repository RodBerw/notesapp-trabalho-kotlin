package br.edu.up.app.ui.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatDelegate
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

        var darkModeSwitch: Switch = binding.switchDarkMode
        var sbFontSize: SeekBar = binding.sbFontSize

        binding.sbFontSize.progress = (viewModel.fontSize - 16).toInt()
        binding.txtFontSize.text = viewModel.fontSize.toString()

        sbFontSize.setOnSeekBarChangeListener(object :
            OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO Auto-generated method stub
                viewModel.fontSize = 16f + sbFontSize.progress.toFloat()
                binding.txtFontSize.text = viewModel.fontSize.toString()
                binding.txtNotationEx.textSize = viewModel.fontSize
            }
        })

        darkModeSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        })


//        addOnLayoutChangeListener{ view: View, i: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int, i7: Int ->
//              viewModel.fontSize = 16f + sbFontSize.progress.toFloat()
//               binding.txtNotationEx.textSize = viewModel.fontSize
//        }



        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}