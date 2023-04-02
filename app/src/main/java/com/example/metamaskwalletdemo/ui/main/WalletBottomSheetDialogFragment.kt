package com.example.metamaskwalletdemo.ui.main

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamaskwalletdemo.R
import com.example.metamaskwalletdemo.databinding.BottomSheetDialogWalletListBinding
import com.example.metamaskwalletdemo.model.Wallet
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WalletBottomSheetDialogFragment(
    wallets: List<Wallet>,
) : BottomSheetDialogFragment(), ItemClickListener {
    private lateinit var binding: BottomSheetDialogWalletListBinding
    private val bottomSheetWalletAdapter = BottomSheetWalletAdapter(
        wallets = wallets,
        onClickWallet = {
            Toast.makeText(requireContext(), it.address, Toast.LENGTH_SHORT).show()
        }
    )

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { setupBottomSheet(it) }
        return dialog
    }

    private fun setupBottomSheet(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet = bottomSheetDialog.findViewById<View>(
            com.google.android.material.R.id.design_bottom_sheet
        )
            ?: return
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_dialog_wallet_list,
            container,
            false
        )
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.walletRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = bottomSheetWalletAdapter
        }
    }

    override fun onItemClick(item: Wallet) {
        Toast.makeText(requireContext(), "${item.name} 클릭", Toast.LENGTH_SHORT).show()
        dismiss()
    }
}