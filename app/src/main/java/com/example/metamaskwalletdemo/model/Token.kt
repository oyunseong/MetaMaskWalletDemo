package com.example.metamaskwalletdemo.model

enum class TokenType {
    ETH, SNX, LINE, MKR, WBTC
}

data class Token(
    val type: TokenType,
    val count: Int,
) {
    val price: Double get() {
        return when (type) {
            TokenType.ETH -> 1.2
            TokenType.MKR -> 2.5
            TokenType.SNX -> 3.1
            TokenType.LINE -> 4.2
            TokenType.WBTC -> 5.7
        } * count
    }
}
