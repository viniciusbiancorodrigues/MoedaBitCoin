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
        private var coinModels: MutableList<CoinModel>,
        private val onCoinClick: (coinModel: CoinModel) -> Unit
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

    override fun getItemCount(): Int = coinModels.size

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinModels[position])
    }

    fun updateCoins(coinModels: List<CoinModel>) {
        this.coinModels.addAll(coinModels)
        notifyItemRangeInserted(
                this.coinModels.size,
                coinModels.size - 1
        )
    }

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon: ImageView = itemView.findViewById(R.id.xxxxxxxxxxxxx)
        private val assetId: TextView = itemView.findViewById(R.id.xxxxxxxxxxxx)
        private val name: TextView = itemView.findViewById(R.id.xxxxxxxxxxxxx)
        private val valueUsd: TextView = itemView.findViewById(R.id.xxxxxxxxxxx)

        fun bind(coins: CoinModel) {
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

/*
class CoinAdapter(private val onCoinClick: (coinModel: CoinModel) -> Unit) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    var coinList: List<CoinModel>

    init {
        coinList = ArrayList()
    }

    fun addData(arrList: List<CoinModel>) {
        this.coinList = arrList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.xxxxxxxxxxxxx, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon: ImageView = itemView.findViewById(R.id.xxxxxxxxxxxxx)
        private val assetId: TextView = itemView.findViewById(R.id.xxxxxxxxxxxx)
        private val name: TextView = itemView.findViewById(R.id.xxxxxxxxxxxxx)
        private val valueUsd: TextView = itemView.findViewById(R.id.xxxxxxxxxxx)

        fun bind(coins: CoinModel) {
            name.text = "${coins.name}"
            assetId.text = coins.assetId
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

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(coinList[position])
    }
}
*/
