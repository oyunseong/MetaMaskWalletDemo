package com.example.metamaskwalletdemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamaskwalletdemo.databinding.ItemWalletBinding
import com.example.metamaskwalletdemo.model.Wallet

class BottomSheetWalletAdapter(
    private val wallets: List<Wallet>,
    private val onClickWallet: (Wallet) -> Unit,
) :
    RecyclerView.Adapter<BottomSheetWalletAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWalletBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = wallets[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return wallets.size
    }

    inner class ViewHolder(private val binding: ItemWalletBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Wallet) {
            binding.adapter = this@BottomSheetWalletAdapter
            binding.wallet = item
//            binding.walletName.text = "${item.name}"
//            binding.tokenCount.text = "$${item.token.count} ${item.token.type}"
        }
    }

    fun onClick(wallet: Wallet) {
        onClickWallet.invoke(wallet)
    }
}