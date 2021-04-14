package com.example.moedabitcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moedabitcoin.api.CoinRetrofit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var coinView: RecyclerView
    lateinit var coinAdapter: CoinAdapter
    lateinit var coinLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinLayoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        )
        coinView.layoutManager = coinLayoutManager
        coinAdapter = CoinAdapter(mutableListOf()) { coin -> showCoinDetails(coin) }
        coinView.adapter = coinAdapter

        getCryptoCoins()
    }

    private fun getCryptoCoins() {
        CoinRetrofit.getCryptoCurrency(
                ::onCoinCurrencyFetched,
                ::onError
        )
    }

    private fun onCoinCurrencyFetched(coins: List<CoinModel>) {
        coinAdapter.updateCoins(coins)

    }

    private fun onError() {
        Toast.makeText(this, "Verifique sua conexão com a internet", Toast.LENGTH_SHORT).show()
    }

//    private fun showCoinDetails(coin: CoinModel) {
//        val intent = Intent(this, CoinDetails::class.java)
//        intent.putExtra
//    }
}