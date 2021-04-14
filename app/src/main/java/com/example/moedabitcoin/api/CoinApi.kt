package com.example.moedabitcoin.api
<<<<<<< HEAD

=======
>>>>>>> fbb80073c142d75d638a28b91b243291adb15a73
import com.example.moedabitcoin.CoinModel
import retrofit2.Call
import retrofit2.http.GET

interface CoinApi {

    @GET("v1/assets")
    fun getCoin(): Call<List<CoinModel>>
}

interface CoinApi {

    @GET("v1/assets")
    fun getCoin(): Call<List<CoinModel>>
}