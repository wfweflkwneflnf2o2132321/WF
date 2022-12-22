package com.example.weatherfetcher.feature.wind.domain

import com.example.weatherfetcher.base.attempt
import com.example.weatherfetcher.feature.wind.data.WindRepo

class WindInteractor (private val windRepo: WindRepo) {

    suspend fun getWind(city: String) = attempt { windRepo.getSpeed(city = city)}

}