package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        iv_back.setOnClickListener {
            finish()
        }
    }
}