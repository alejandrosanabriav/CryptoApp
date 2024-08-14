package com.alejandrosanabriav.cryptoapp.data.remote.dto

import com.alejandrosanabriav.cryptoapp.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val logo: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        is_active = is_active,
        logo = logo,
        name = name,
        rank = rank,
        symbol = symbol
    )
}