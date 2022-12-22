package com.example.weatherfetcher.feature

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherfetcher.R
import com.example.weatherfetcher.feature.temperature.ui.UiEvent
import com.example.weatherfetcher.feature.temperature.ui.ViewState
import com.example.weatherfetcher.feature.temperature.ui.TemperatureViewModel
import com.example.weatherfetcher.feature.wind.ui.WindUiEvent
import com.example.weatherfetcher.feature.wind.ui.WindViewModel
import com.example.weatherfetcher.feature.wind.ui.WindViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity() {


    private val tempViewModel: TemperatureViewModel by viewModel()

    private val windViewModel: WindViewModel by viewModel()


    private val tvCity: TextView by lazy { findViewById(R.id.tvCity) }
    private val tvTemp: TextView by lazy { findViewById(R.id.tvTemperature) }
    private val tvWind: TextView by lazy { findViewById(R.id.tvWind) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        tempViewModel.processUIEvent(UiEvent.GetCity(intent.getStringExtra("city").toString()))
        tempViewModel.viewState.observe(this, ::renderTemp)



        windViewModel.processUIEvent(WindUiEvent.GetCity(intent.getStringExtra("city").toString()))
        windViewModel.viewState.observe(this, ::renderWind)



        tvCity.text = intent.getStringExtra("city").toString()
    }

    private fun renderTemp(viewState: ViewState) {
        tvTemp.text = viewState.temperature
    }

    private fun renderWind(viewState: WindViewState) {
        tvWind.text = viewState.speed
    }
}