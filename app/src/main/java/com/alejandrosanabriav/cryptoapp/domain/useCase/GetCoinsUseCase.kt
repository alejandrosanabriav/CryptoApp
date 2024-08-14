package com.alejandrosanabriav.cryptoapp.domain.useCase

import com.alejandrosanabriav.cryptoapp.common.Resource
import com.alejandrosanabriav.cryptoapp.data.remote.dto.toCoin
import com.alejandrosanabriav.cryptoapp.domain.model.Coin
import com.alejandrosanabriav.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coinsList = repository.getCoins()
            val coins = coinsList.map {
                it.toCoin()
            }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "network err"))
        } catch(e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server, check your internet conexion"))
        }
    }
}