package com.example.sushkof

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer = object: CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val token = getSharedPreferences("settings", Context.MODE_PRIVATE).getInt("token", 0)

                if (token != 0) startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                else startActivity(Intent(this@SplashActivity, GuideActivity::class.java))

                finish()
            }
        }
        timer.start()
    }
}