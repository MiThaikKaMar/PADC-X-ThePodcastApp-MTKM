package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.BaseModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodcastModelImpl : PodcastModel, BaseModel() {

    @SuppressLint("CheckResult")
    override fun getGenresList(): LiveData<List<GeneresVO>> {
        mPodcastApi.getGenresList(PARAM_API_VALUE, VALUE_TOP_LEVEL_ONLY)
            .map {
                it.genres
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mPodcastDB.podcastDao().setGenresList(it ?: listOf())
            }
        return mPodcastDB.podcastDao().getGenresList()
    }

    @SuppressLint("CheckResult")
    override fun getRandomEpisode(): LiveData<RandomVO> {
        mPodcastApi.getRandomEpisode(PARAM_API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let {
                    mPodcastDB.podcastDao().setRandomEpisode(it)
                }
            }
        return mPodcastDB.podcastDao().getRandomEpisode()
    }

    @SuppressLint("CheckResult")
    override fun getPlayList(): LiveData<List<PlaylistVO>> {
        mPodcastApi.getPlayList(PODCAST_ID, VALUE_TYPE, VALUE_LAST_TIMESTAMP, VALUE_SORT,PARAM_API_VALUE)
            .map {
                it.items
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mPodcastDB.podcastDao().setPlayList(it)
            }
        return mPodcastDB.podcastDao().getPlayList()
    }

    @SuppressLint("CheckResult")
    override fun getDeatil(detailId : String, onSuccess : (DetailVO)->Unit){
//        mPodcastApi.getDetail(detailId, PARAM_API_VALUE)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                mPodcastDB.podcastDao().setDetail(it)
//            }
//        return mPodcastDB.podcastDao().getDetailById(detailId)

        mPodcastApi.getDetail(detailId, PARAM_API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                onSuccess(it)
            }
    }
}