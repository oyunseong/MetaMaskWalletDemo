package com.example.metamaskwalletdemo.model

data class Wallet(
    val name: String,
    val address: String,
    val token: Token
)

val fakeWallets = listOf<Wallet>(
    Wallet(
        "first wallet",
        "0x8ecasdasdDF",
        Token(TokenType.ETH, 3)
    ),
    Wallet(
        "second wallet",
        "0x5sdasddSAQ",
        Token(TokenType.MKR, 2)
    )
)