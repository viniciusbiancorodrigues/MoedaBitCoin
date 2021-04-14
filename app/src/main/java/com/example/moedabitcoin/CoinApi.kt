package com.example.moedabitcoin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/assets")
    fun getCoin(): Call<List<CoinModel>>
}
