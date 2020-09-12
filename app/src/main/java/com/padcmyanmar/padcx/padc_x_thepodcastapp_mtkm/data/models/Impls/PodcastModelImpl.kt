package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.BaseModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.*
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodcastModelImpl : PodcastModel, BaseModel() {
    @SuppressLint("CheckResult")
    override fun getGenresListFromApiAndSaveDB() {
        mPodcastApi.getGenresList(PARAM_API_VALUE, VALUE_TOP_LEVEL_ONLY)
            .map {
                it.genres
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mPodcastDB.podcastDao().setGenresList(it ?: listOf())
            }
    }


    override fun getGenresList(): LiveData<List<GeneresVO>> {
        return mPodcastDB.podcastDao().getGenresList()
    }

    @SuppressLint("CheckResult")
    override fun getRandomEpisodeFromApiAndSaveDB() {
        mPodcastApi.getRandomEpisode(PARAM_API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let {
                    mPodcastDB.podcastDao().setRandomEpisode(it)
                }
            }
    }


    override fun getRandomEpisode(): LiveData<RandomVO> {
        return mPodcastDB.podcastDao().getRandomEpisode()
    }

    @SuppressLint("CheckResult")
    override fun getPlayListFromApiAndSaveDB() {
        mPodcastApi.getPlayList(PODCAST_ID, VALUE_TYPE, VALUE_LAST_TIMESTAMP, VALUE_SORT,PARAM_API_VALUE)
            .map {
                it.items
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let {
                    mPodcastDB.podcastDao().setPlayList(it)
                }
            }
    }

    override fun getPlayList(): LiveData<List<PlaylistVO>> {
        return mPodcastDB.podcastDao().getPlayList()
    }

    @SuppressLint("CheckResult")
    override fun getDetailFromApiAndSaveDB(detailId: String,onSuccess: (detail : DetailVO) -> Unit) {
        mPodcastApi.getDetail(detailId, PARAM_API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mPodcastDB.podcastDao().setDetail(it)
                onSuccess(it)
            },{
                Log.e("Error",it.toString())

            })
    }

    override fun getDeatil(detailId : String
    ) : LiveData<DetailVO> {
        return mPodcastDB.podcastDao().getDetail(detailId)
    }

    override fun getDetailById(detailId: String): LiveData<PlaylistVO> {
        return mPodcastDB.podcastDao().getDetailById(detailId)
    }

    override fun startDownloadPodcast(context: Context, dataVO: DataVO) {
        Toast.makeText(context,"Start Downloading", Toast.LENGTH_LONG).show()
        startDownloading(context,dataVO)
    }

    override fun getDownloadPodcastList(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
        return mPodcastDB.podcastDao().getAllDownloadPodcastData()
    }

    override fun saveDownloadPodcastItem(
        donwloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mPodcastDB.podcastDao().insertDownloadPodcastData(donwloadVO)
    }
}