package com.example.submisionakhiraplikasi_mbti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//Kode untuk menjalankan main screen setelah timer splash screen habis
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, 3000)
    }
}