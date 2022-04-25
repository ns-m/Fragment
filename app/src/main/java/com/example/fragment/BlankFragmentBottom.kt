package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
//import com.example.fragment.databinding.FragmentBlank2Binding
import com.example.fragment.databinding.FragmentBottomBinding


class BlankFragmentBottom : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBottomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val binding = FragmentBlank2Binding.inflate(inflater)
        binding = FragmentBottomBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrgmBttn.observe(activity as LifecycleOwner,{
            binding.textViewFrgmBttm.text = it
        })
        binding.buttonSendToFrgTop.setOnClickListener {
            dataModel.messageForFrgmTp.value = "Data from Bottom! fragment"
        }
        binding.buttonSendToActv.setOnClickListener {
            dataModel.messageForActivity.value = "Data to activity from fragment Bottom!"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragmentBottom()
    }
}