package com.example.metamaskwalletdemo.ui.swap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.metamaskwalletdemo.R
import com.example.metamaskwalletdemo.databinding.FragmentSwapBinding

class SwapFragment : Fragment() {
    private lateinit var binding: FragmentSwapBinding
    private val swapViewModel by viewModels<SwapViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_swap, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = swapViewModel

        return binding.root
    }

}

