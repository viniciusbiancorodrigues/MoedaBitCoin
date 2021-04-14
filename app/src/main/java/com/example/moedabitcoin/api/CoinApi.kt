package com.example.moedabitcoin.api

import com.example.moedabitcoin.CoinResponse

<<<<<<< HEAD:app/src/main/java/com/example/moedabitcoin/CoinApi.kt
=======
>>>>>>> bf4171c8abd8b1925326c34358aebbf7b7821bb0:app/src/main/java/CoinApi.kt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/assets")
    fun getCoin(@Query("Apikey") apikey : String = "267ED9D8-119E-44DC-B5D5-2AFC2140E717"): Call<CoinResponse>
}
