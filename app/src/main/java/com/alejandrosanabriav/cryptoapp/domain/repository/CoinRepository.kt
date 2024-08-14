package com.alejandrosanabriav.cryptoapp.domain.repository

import com.alejandrosanabriav.cryptoapp.data.remote.dto.CoinDetailDto
import com.alejandrosanabriav.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}