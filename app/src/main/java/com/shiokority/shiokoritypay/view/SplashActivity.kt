package com.shiokority.shiokoritypay.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.shiokority.shiokoritypay.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

//            =====================================================================
//            bypass login screen
//            startActivity(Intent(this, MainActivity::class.java))
//            =====================================================================
//            with login screen
            startActivity(Intent(this, LoginActivity::class.java))
//            =====================================================================
            finish()
        }, 2000) // 2000 ms = 2 seconds
    }
}