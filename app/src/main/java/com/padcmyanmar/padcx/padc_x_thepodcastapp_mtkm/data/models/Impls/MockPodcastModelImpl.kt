package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getDownloadList
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getGenresVOList
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getPlayListVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.*

object MockPodcastModelImpl : PodcastModel {
    override fun getGenresListFromApiAndSaveDB() {

    }

    override fun getGenresList(): LiveData<List<GeneresVO>> {
        val liveData = MutableLiveData<List<GeneresVO>>()
        liveData.postValue(getGenresVOList())
        return liveData
    }

    override fun getRandomEpisodeFromApiAndSaveDB() {

    }

    override fun getRandomEpisode(): LiveData<RandomVO> {
        val liveData = MutableLiveData<RandomVO>()
        liveData.postValue(RandomVO())
        return liveData

    }

    override fun getPlayListFromApiAndSaveDB() {

    }

    override fun getPlayList(): LiveData<List<PlaylistVO>> {
        val liveData = MutableLiveData<List<PlaylistVO>>()
        liveData.postValue(getPlayListVO())
        return liveData
    }

    override fun getDetailFromApiAndSaveDB(
        detailId: String,
        onSuccess: (detail: DetailVO) -> Unit
    ) {

    }

    override fun getDeatil(detailId: String): LiveData<DetailVO> {
        val liveData = MutableLiveData<DetailVO>()
        liveData.postValue(DetailVO())
        return liveData
    }

    override fun startDownloadPodcast(context: Context, dataVO: DataVO) {

    }

    override fun getDownloadPodcastList(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
        val liveData = MutableLiveData<List<DownloadVO>>()
        liveData.postValue(getDownloadList())
        return liveData
    }

    override fun saveDownloadPodcastItem(
        donwloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }
}