package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment.databinding.FragmentTopBinding

class BlankFragmentTop : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentTopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrgmTp.observe(activity as LifecycleOwner,{
            binding.textViewFrgmTp.text = it
        })
        binding.buttonSendToFrgBttm.setOnClickListener {
            dataModel.messageForFrgmBttn.value = "Data from Top fragment"
        }
        binding.buttonSendToActv.setOnClickListener {
            dataModel.messageForActivity.value = "Data to activity from fragment Top"
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = BlankFragmentTop()

    }
}