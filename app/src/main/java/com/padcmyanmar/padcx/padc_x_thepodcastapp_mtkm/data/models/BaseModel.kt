package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models

import android.content.Context
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.network.PodcastApi
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.db.PodcastDatabase
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseModel {

    protected var mPodcastApi : PodcastApi
    protected lateinit var mPodcastDB : PodcastDatabase

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodcastApi = retrofit.create(PodcastApi::class.java)

    }

    fun initDatabase(context: Context){
        mPodcastDB= PodcastDatabase.getDBInstance(context)
    }
}