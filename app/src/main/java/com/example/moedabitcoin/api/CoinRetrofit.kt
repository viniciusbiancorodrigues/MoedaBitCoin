package com.example.moedabitcoin.api

<<<<<<< HEAD:app/src/main/java/com/example/moedabitcoin/api/CoinRetrofit.kt
import com.example.moedabitcoin.Coin
import com.example.moedabitcoin.CoinResponse
import retrofit2.Retrofit
=======
import android.util.Log
import androidx.lifecycle.MutableLiveData
>>>>>>> 201edc3dd0615df8d5a3bfd6115e3af09144469f:app/src/main/java/com/example/moedabitcoin/CoinRetrofit.kt
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class CoinRetrofit {

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
    private val api: CoinApi = RetrofitClient.getRetrofitInstance(Constants().BASE_URL)
            .create(CoinApi::class.java)

    fun getCryptoCurrency(
            onSuccess: (coinModel: List<CoinModel>) -> Unit,
            onError: () -> Unit
    ) {
        api.getCoin()
                .enqueue(object : Callback<List<CoinModel>> {
                    override fun onResponse(
                            call : Call<List<CoinModel>>,
                            response: Response<List<CoinModel>>
                    ) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()

                            if (responseBody != null) {
                                onSuccess.invoke(responseBody.)
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
