package com.example.moedabitcoin

import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory

object CoinRetrofit {

    private val api: CoinApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://rest.coinapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(CoinApi::class.java)
    }

    fun getCryptoCurrency(
            onSuccess: (coins: List<Coin>) -> Unit,
            onError: () -> Unit
    ) {
        api.getCoin()
                .enqueue(object : Callback<CoinsResponse> {
                    override fun onResponse(
                            call : Call<CoinsResponse>,
                            response: Response<CoinsResponse>
                    ) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()

                            if (responseBody != null) {
                                onSuccess.invoke(responseBody.coins)
                            } else {
                                onError.invoke()
                            }
                        } else {
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<CoinsResponse>, t: Throwable) {
                        onError.invoke()
                    }
                })
    }
}