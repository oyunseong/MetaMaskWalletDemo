package com.example.metamaskwalletdemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamaskwalletdemo.databinding.ItemAssetBinding
import com.example.metamaskwalletdemo.model.Token

class AssetAdapter(private val itemList: List<Token>) :
    RecyclerView.Adapter<AssetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(private val binding: ItemAssetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Token) {
            binding.tokenCount.text = "${item.count} ${item.type}"

            binding.tokenPrice.text = "$${item.price} USD"
        }
    }
}