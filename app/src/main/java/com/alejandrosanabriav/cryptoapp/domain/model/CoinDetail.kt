package com.alejandrosanabriav.cryptoapp.domain.model

import com.alejandrosanabriav.cryptoapp.data.remote.dto.Tag
import com.alejandrosanabriav.cryptoapp.data.remote.dto.Team

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<Tag>,
    val team: List<Team>
)