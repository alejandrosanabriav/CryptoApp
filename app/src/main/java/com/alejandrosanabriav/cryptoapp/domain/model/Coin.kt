package com.alejandrosanabriav.cryptoapp.domain.model

data class Coin(
    val id: String,
    val is_active: Boolean,
    val logo: String,
    val name: String,
    val rank: Int,
    val symbol: String,
)
