package com.alejandrosanabriav.cryptoapp.presentation.coinDetail

import com.alejandrosanabriav.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)