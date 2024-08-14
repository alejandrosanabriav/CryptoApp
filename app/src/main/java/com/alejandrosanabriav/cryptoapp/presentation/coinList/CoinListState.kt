package com.alejandrosanabriav.cryptoapp.presentation.coinList

import com.alejandrosanabriav.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
