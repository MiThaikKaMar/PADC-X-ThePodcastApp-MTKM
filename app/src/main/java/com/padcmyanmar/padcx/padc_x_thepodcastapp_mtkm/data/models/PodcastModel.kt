package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.*

interface PodcastModel  {
    fun getGenresListFromApiAndSaveDB()
    fun getGenresList():LiveData<List<GeneresVO>>

    fun getRandomEpisodeFromApiAndSaveDB()
    fun getRandomEpisode():LiveData<RandomVO>

    fun getPlayListFromApiAndSaveDB()
    fun getPlayList(): LiveData<List<PlaylistVO>>

    fun getDetailFromApiAndSaveDB(detailId : String,onSuccess: (detail:DetailVO) -> Unit)
    fun getDeatil(detailId : String): LiveData<DetailVO>
    fun getDetailById(detailId: String):LiveData<PlaylistVO>

    fun startDownloadPodcast(context: Context, dataVO: DataVO)
    fun getDownloadPodcastList(onError: (String) -> Unit) : LiveData<List<DownloadVO>>
    fun saveDownloadPodcastItem(donwloadVO: DownloadVO, onSuccess: () -> Unit, onError: (String) -> Unit)
}