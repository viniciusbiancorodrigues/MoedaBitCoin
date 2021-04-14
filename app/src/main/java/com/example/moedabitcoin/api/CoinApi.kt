package com.example.moedabitcoin.api
import com.example.moedabitcoin.CoinModel
import retrofit2.Call
import retrofit2.http.GET

interface CoinApi {

    @GET("v1/assets")
    fun getCoin(): Call<List<CoinModel>>
}
