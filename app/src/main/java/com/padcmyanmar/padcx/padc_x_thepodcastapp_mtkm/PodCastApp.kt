package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm

import android.app.Application
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl

class PodCastApp : Application() {
    override fun onCreate() {
        super.onCreate()

        PodcastModelImpl.initDatabase(applicationContext)
    }
}