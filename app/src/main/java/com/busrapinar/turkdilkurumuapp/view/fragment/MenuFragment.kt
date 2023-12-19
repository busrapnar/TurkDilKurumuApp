package com.busrapinar.turkdilkurumuapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.busrapinar.turkdilkurumuapp.R
import com.busrapinar.turkdilkurumuapp.databinding.FragmentMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var binding : FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMenuBinding.inflate(inflater, container, false)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.apply {
            tvAboutUs.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_aboutusFragment2)
            }
            tvContact.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_contactFragment2)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}