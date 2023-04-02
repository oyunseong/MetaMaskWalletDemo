package com.example.metamaskwalletdemo.model.repository

import com.example.metamaskwalletdemo.model.Wallet
import com.example.metamaskwalletdemo.model.datasource.WalletApi

class WalletRepository(private val walletApi: WalletApi = WalletApi) {
    suspend fun getWallets(): List<Wallet> {
        return walletApi.getWalletList()
    }
}