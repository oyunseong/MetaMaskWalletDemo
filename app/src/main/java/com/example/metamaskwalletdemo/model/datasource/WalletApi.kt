package com.example.metamaskwalletdemo.model.datasource

import com.example.metamaskwalletdemo.model.Wallet
import com.example.metamaskwalletdemo.model.fakeWallets
import kotlinx.coroutines.delay

// 서버 API
object WalletApi {

    /**
     * 지갑 목록을 조회합니다.
     */
    suspend fun getWalletList(): List<Wallet> {
        delay(200L)
        return fakeWallets
    }

}