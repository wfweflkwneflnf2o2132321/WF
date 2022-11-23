package com.example.weatherfetcher

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class WA : AppCompatActivity() {
    private val weatherP = WeatherP()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aw)
        val tvTemperature =findViewById<TextView>(R.id.tvTemperature)
        tvTemperature.text = weatherP.getWeather(UUID.randomUUID().toString())
    }
}