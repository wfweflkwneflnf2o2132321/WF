package com.example.weatherfetcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var  presenter: WeatherScreenPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter =WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(WeatherApiClient.getApi())

                )
            )
        )
        var weather =""
        val textViewHello = findViewById<TextView>(R.id.tvHello)

        GlobalScope.launch {
          withContext(Dispatchers.Main){
              textViewHello.text =presenter.getWeather()
          }
        }


        textViewHello.text

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
             Intent(this,WA::class.java).also { startActivity(it) }

        }
    }
}