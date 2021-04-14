package com.example.moedabitcoin

import com.google.gson.annotations.SerializedName

data class Coin (

        @SerializedName("asset_id")
        val assetId : Long,

        val name : String?,

        @SerializedName("volume_1hrs_usd")
        val valueLastHour: Double,

        @SerializedName("volume_1day_usd")
        val valueLastDay: Double,

        @SerializedName("volume_1mth_usd")

        val valueLastMonth: Double,

        @SerializedName("price_usd")
        val valueUsd: Double?,
        
        @SerializedName("id_icon")
        val valueIcon: String?

        )

