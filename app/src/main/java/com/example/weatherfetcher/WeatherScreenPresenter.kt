package com.example.weatherfetcher

class WeatherScreenPresenter(val interactor: WeatherInteractor) {
    suspend fun getWeather():String{
        return interactor.getWeather()
    }
}