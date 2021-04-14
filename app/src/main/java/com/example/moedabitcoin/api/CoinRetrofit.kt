package com.example.moedabitcoin.api

import com.example.moedabitcoin.CoinModel
import com.example.moedabitcoin.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

object CoinRetrofit {

    private val api: CoinApi = RetrofitClient.getRetrofitInstance(Constants().BASE_URL)
            .create(CoinApi::class.java)

    fun getCryptoCurrency(
            onSuccess: (coinModel: List<CoinModel>) -> Unit,
            onError: () -> Unit
    ) {
        api.getCoin()
                .enqueue(object : Callback<List<CoinModel>> {
                    override fun onResponse(
                            call: Call<List<CoinModel>>,
                            response: Response<List<CoinModel>>
                    ) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()

                            if (responseBody != null) {
                                onSuccess.invoke(responseBody)
                            } else {
                                onError.invoke()
                            }
                        } else {
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<List<CoinModel>>, t: Throwable) {
                        onError.invoke()
                    }
                })
    }
}

    /*
    val TAG: String = javaClass.simpleName

    fun fetchCoins(): MutableLiveData<List<CoinModel>> {
        var mutableList: MutableLiveData<List<CoinModel>> = MutableLiveData()

        val apiInterface = RetrofitClient.getRetrofitInstance(Constants().BASE_URL)
                .create(CoinApi::class.java)

        apiInterface.getCoin().enqueue(object : Callback<List<CoinModel>> {
            override fun onResponse(
                    call: Call<List<CoinModel>>,
                    response: Response<List<CoinModel>>
            ) {
                Log.e(TAG, "onResponse response=" + response.toString())

                if (response.isSuccessful) {
                    Log.e(TAG, "onResponse response.size=" + response.body()?.size)

                    if (response.body() != null && response.body()?.size!! > 0) {
                        mutableList.value = response.body()!!
                    }
                }
            }

            override fun onFailure(call: Call<List<CoinModel>>, t: Throwable) {
                Log.e(TAG, "onFailure call=" + call.toString())
            }

        })

        return mutableList
    }
}
*/
