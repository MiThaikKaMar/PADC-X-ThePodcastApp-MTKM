package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO

interface PodcastModel  {
    fun getGenresList():LiveData<List<GeneresVO>>
    fun getRandomEpisode():LiveData<RandomVO>
    fun getPlayList(): LiveData<List<PlaylistVO>>
    fun getDeatil(detailId : String,onSuccess:(DetailVO)->Unit)
}