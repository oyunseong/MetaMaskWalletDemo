package com.example.metamaskwalletdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamaskwalletdemo.R
import com.example.metamaskwalletdemo.databinding.FragmentAssetBinding
import com.example.metamaskwalletdemo.model.Token
import com.example.metamaskwalletdemo.model.TokenType

class AssetFragment : Fragment() {
    private lateinit var binding: FragmentAssetBinding
    private val assetAdapter = AssetAdapter(listOf(Token(TokenType.MKR, 2)))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_asset, container, false)
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.assetRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = assetAdapter
        }
    }


}