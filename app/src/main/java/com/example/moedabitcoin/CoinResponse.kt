package com.example.moedabitcoin

import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val coins: List<Coin>
)
