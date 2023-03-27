package com.example.submisionakhiraplikasi_mbti

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var ivPhoto : ImageView
    private lateinit var tvName : TextView
    private lateinit var tvDes : TextView
    private lateinit var tvType : TextView

    companion object {
        const val DATA_MBTI = "data_mbti"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ivPhoto =findViewById(R.id.iv_mbti)
        tvName = findViewById(R.id.data_mbtii)
        tvDes = findViewById(R.id.data_descrip)
        tvType = findViewById(R.id.data_typee)

        val mbti = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<MBTI>(DATA_MBTI, MBTI::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<MBTI>(DATA_MBTI)
        }
        if(mbti != null){
            Glide.with(this)
                .load(mbti.photo) // URL Gambar
                .into(ivPhoto)
            tvName.text = mbti.name
            tvDes.text = mbti.description
            tvType.text = mbti.type
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}