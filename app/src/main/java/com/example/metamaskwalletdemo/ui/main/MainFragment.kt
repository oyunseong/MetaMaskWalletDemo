package com.example.metamaskwalletdemo.ui.main

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.metamaskwalletdemo.R
import com.example.metamaskwalletdemo.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = mainViewModel
        binding.fragment = this

        // 스왑 화면으로 이동
        binding.swapButton.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SwapFragment)
        }

        binding.walletAddress.let { textView ->
            textView.setOnClickListener {
                copyText(textView.text.toString())
                Toast.makeText(requireContext(), "토큰 주소가 복사되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        val viewpagerFragmentAdapter = ViewPagerAdapter(requireActivity())

        binding.viewpager2.adapter = viewpagerFragmentAdapter
        val tabTitles = listOf<String>("자산", "활동")
        TabLayoutMediator(binding.tabLayout, binding.viewpager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        return binding.root
    }

    fun showWalletDialog() {
        val dialog =
            WalletBottomSheetDialogFragment(mainViewModel.wallets.value ?: emptyList())
        dialog.show(parentFragmentManager, dialog.tag)
    }

    private fun copyText(text: String) {
        val clipBoard: ClipboardManager =
            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("text", text)
        clipBoard.setPrimaryClip(clip)
    }

}