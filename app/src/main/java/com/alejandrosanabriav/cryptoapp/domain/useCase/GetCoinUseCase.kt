package com.alejandrosanabriav.cryptoapp.domain.useCase

import com.alejandrosanabriav.cryptoapp.common.Resource
import com.alejandrosanabriav.cryptoapp.data.remote.dto.toCoin
import com.alejandrosanabriav.cryptoapp.data.remote.dto.toCoinDetail
import com.alejandrosanabriav.cryptoapp.domain.model.Coin
import com.alejandrosanabriav.cryptoapp.domain.model.CoinDetail
import com.alejandrosanabriav.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository,

) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "network err"))
        } catch(e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server, check your internet conexion"))
        }
    }
}