package com.example.moedabitcoin.api

import com.example.moedabitcoin.CoinResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/assets")
    fun getCoin(@Query("Apikey") apikey : String = "267ED9D8-119E-44DC-B5D5-2AFC2140E717"): Call<CoinResponse>
}
