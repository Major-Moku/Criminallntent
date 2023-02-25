package com.example.criminallntent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.criminallntent.databinding.FragmentCrimeDetailBinding
import java.util.*

class CrimeDetailFragment : Fragment() {
    private lateinit var crime: Crime
//    private lateinit var binding: FragmentCrimeDetailBinding
    private var _binding: FragmentCrimeDetailBinding? = null // 为了deastroy的正常使用
    private val binding
        get() = checkNotNull(_binding){
            "can not access binding cause it is null. Is the view visible?"
        }

    override fun onCreate(savedInstanceState: Bundle?) {  //初始化
        super.onCreate(savedInstanceState)
        crime =Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }

    override fun onCreateView(  // inflate and bind the layout for the fragment and return the inflated view
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false) // inflate它的作用是将一个layout.xml布局文件变为一个View对象,加载一个布局
        return binding.root //binding.root表示最外层的View
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {  // wire up
        super.onViewCreated(view, savedInstanceState)
        binding.apply{
            crimeTitle.doOnTextChanged { text, _, _, _ -> // set a listener
                crime = crime.copy(title = text.toString())
            }
            crimeDate.apply {
                text = crime.date.toString()  // not respond to pressing
                isEnabled = false
            }

            crimeSolved.setOnCheckedChangeListener{ _, isChecked ->
                crime = crime.copy(isSolved = isChecked)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}