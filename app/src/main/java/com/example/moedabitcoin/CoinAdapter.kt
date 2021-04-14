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
    private var coins: MutableList<CoinModel>,
    private val onCoinClick: (coinModel: CoinModel) -> Unit
) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): CoinViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.activity_coin_item, parent, false)
        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int = coins.size

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coins[position])
    }

    fun updateCoins(coinModels: List<CoinModel>) {
        this.coins.addAll(coinModels)
        notifyItemRangeInserted(
                this.coins.size,
                coins.size - 1
        )
    }

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon: ImageView = itemView.findViewById(R.id.item_coin_icon)
//        private val assetId: TextView = itemView.findViewById(R.id.xxxxxxxxxxxx)
        private val name: TextView = itemView.findViewById(R.id.item_coin_name)
//        private val valueUsd: TextView = itemView.findViewById(R.id.xxxxxxxxxxx)

      fun bind(coins: CoinModel) {
            name.text = "${coins.name}"
//            assetId.text = "${coins.assetId}"
//            valueUsd.text = "${coins.valueUsd}"

          if (coins.valueIcon != null) {
                var iconPath = coins.valueIcon!!.replace("-", "")
              Glide.with(itemView)
                  .load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_16/$iconPath.png")
                  .transform(CenterCrop())
                  .into(icon)
            } else {
                var iconPath = "4caf2b16a0174e26a3482cea69c34cba"
              Glide.with(itemView)
                  .load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_16/$iconPath.png")
                  .transform(CenterCrop())
                  .into(icon)
          }
            itemView.setOnClickListener {
                onCoinClick.invoke(coins)
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
                .inflate(R.layout.activity_coin_item, parent, false)
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
