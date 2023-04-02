package com.example.metamaskwalletdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.metamaskwalletdemo.R
import com.example.metamaskwalletdemo.databinding.FragmentActivityBinding
import com.example.metamaskwalletdemo.databinding.FragmentAssetBinding

class ActivityFragment : Fragment() {
    private lateinit var binding: FragmentActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_activity, container, false)
        return binding.root
    }


}