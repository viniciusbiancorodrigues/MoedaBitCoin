package com.example.moedabitcoin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class CoinAdapter (
        private var coins: MutableList<Coin>,
        private val onCoinClick: (coin: Coin) -> Unit
) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): CoinViewHolder {
       val view = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.xxxxxxxxxxxxxxxxxxxxxxx, parent, false)
        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int = coins.size

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coins[position])
    }

    fun updateCoins(coins: List<Coin>) {
        this.coins.addAll(coins)
        notifyItemRangeInserted(
            this.coins.size,
            coins.size - 1
        )
    }

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon: ImageView = itemView.findViewById(R.id.xxxxxxxxxxxxx)
        private val assetId: TextView = itemView.findViewById(R.id.xxxxxxxxxxxx)
        private val name: TextView = itemView.findViewById(R.id.xxxxxxxxxxxxx)
        private val valueUsd: TextView = itemView.findViewById(R.id.xxxxxxxxxxx)



        fun bind(coins: Coin) {
            name.text = "${coins.name}"
            assetId.text = "${coins.assetId}"
            valueUsd.text = "${coins.valueUsd}"

            Glide.with(itemView)
                .load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_32${coins.valueIcon}")
                .transform(CenterCrop())
                .into(icon)
            itemView.setOnClickListener {
                onCoinClick
            }

        }
    }
}

