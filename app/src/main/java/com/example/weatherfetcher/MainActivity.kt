package com.example.weatherfetcher


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherfetcher.feature.SecondActivity


class MainActivity : AppCompatActivity() {

    private val etCity: EditText by lazy { findViewById(R.id.etCity) }
    private val btn: Button by lazy { findViewById(R.id.button) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {
            val city = etCity.text.toString()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            Intent(intent)
            // в ключ username пихаем текст из первого текстового поля
            intent.putExtra("city", city)
            startActivity(intent)
        }
    }
}