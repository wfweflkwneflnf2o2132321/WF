package com.example.weatherfetcher.feature.wind.data

import com.example.weatherfetcher.feature.wind.data.network.model.WindRemoteModel
import com.example.weatherfetcher.feature.wind.domain.WindModel


fun WindRemoteModel.toDomain() = WindModel(
    speed = this.wind.speed
)