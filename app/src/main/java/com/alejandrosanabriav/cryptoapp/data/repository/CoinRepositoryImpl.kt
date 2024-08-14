package com.alejandrosanabriav.cryptoapp.data.repository

import com.alejandrosanabriav.cryptoapp.data.remote.api.CoinPaprikaApi
import com.alejandrosanabriav.cryptoapp.data.remote.dto.CoinDetailDto
import com.alejandrosanabriav.cryptoapp.data.remote.dto.CoinDto
import com.alejandrosanabriav.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}