package com.example.metamaskwalletdemo.ui.swap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.metamaskwalletdemo.model.Token

class SwapViewModel : ViewModel() {
    private var _tokenList: MutableLiveData<List<Token>> = MutableLiveData()
    val tokenList: LiveData<List<Token>> get() = _tokenList

}