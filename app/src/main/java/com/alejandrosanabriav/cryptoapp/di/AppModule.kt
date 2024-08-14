package com.alejandrosanabriav.cryptoapp.di

import com.alejandrosanabriav.cryptoapp.common.Constants
import com.alejandrosanabriav.cryptoapp.data.remote.api.CoinPaprikaApi
import com.alejandrosanabriav.cryptoapp.data.repository.CoinRepositoryImpl
import com.alejandrosanabriav.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}