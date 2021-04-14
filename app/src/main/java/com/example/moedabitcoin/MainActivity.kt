package com.example.moedabitcoin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moedabitcoin.api.CoinRetrofit

class MainActivity : AppCompatActivity() {

    private lateinit var coinView: RecyclerView
    private lateinit var coinAdapter: CoinAdapter
    private lateinit var coinLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinView = findViewById(R.id.coin_currency)
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
        Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
    }

    private fun showCoinDetails(coin: CoinModel) {
    //    val intent = Intent(this, CoinDetails::class.java)
    //    intent.putExtra
    }
}