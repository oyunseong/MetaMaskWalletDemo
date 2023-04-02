package com.example.metamaskwalletdemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metamaskwalletdemo.model.Wallet
import com.example.metamaskwalletdemo.model.repository.WalletRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val walletRepository: WalletRepository = WalletRepository()
) : ViewModel() {

    private var _wallet: MutableLiveData<Wallet> = MutableLiveData()
    val wallet: LiveData<Wallet> get() = _wallet

    private var _wallets: MutableLiveData<List<Wallet>> = MutableLiveData()
    val wallets: LiveData<List<Wallet>> get() = _wallets

    init {
        loadWallet()
    }

    private fun loadWallet() {
        viewModelScope.launch {
            try {
                _wallets.value = walletRepository.getWallets()
                _wallet.value = wallets.value?.get(0)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}