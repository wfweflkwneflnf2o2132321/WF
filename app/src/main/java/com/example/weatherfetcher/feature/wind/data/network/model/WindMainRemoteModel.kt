package com.example.weatherfetcher.feature.wind.data.network.model

import com.google.gson.annotations.SerializedName

data class WindMainRemoteModel (
    @SerializedName("speed")
    val speed: String
)