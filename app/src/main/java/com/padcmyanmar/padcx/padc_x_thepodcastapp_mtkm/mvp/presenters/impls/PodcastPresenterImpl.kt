package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.PodcastPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.PodcastView

class PodcastPresenterImpl : PodcastPresenter,AbstractBasePresenter<PodcastView>() {

    val mPodcastModelImpl :PodcastModel=PodcastModelImpl


    override fun onUiReady(lifecycleOwner: LifecycleOwner,id: String) {
        requestRandomEpisode(lifecycleOwner)
        requestPlayList(lifecycleOwner)
    }


    private fun requestRandomEpisode(lifecycleOwner: LifecycleOwner){
        mPodcastModelImpl.getRandomEpisode()
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.showRandomEpisode(it)
                }
            })
    }

    private fun requestPlayList(lifecycleOwner: LifecycleOwner){
        mPodcastModelImpl.getPlayList()
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayPlayList(it)
                }
            })
    }



    override fun onTapItem(id :String) {
        mView?.navigateToDetailScreen(id)
    }

    override fun onTapDownloadPodcastItem(dataVO: DataVO) {
        val downloadVO: DownloadVO = DownloadVO(
            dataVO.id2, dataVO.title, dataVO.description,
            dataVO.thumbnail, dataVO.title.trim().substring(0,8))

        mPodcastModelImpl.saveDownloadPodcastItem(downloadVO,onSuccess = {}, onError = {})
        mView?.selectedDownloadItem(dataVO)
    }

    override fun onTouchPlayPause(audioUrl: String) {
        mView?.onTouchPlayPauseImage(audioUrl)
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }


    override fun onDownloadPodcastItem(context: Context, data: DataVO) {
        mPodcastModelImpl.startDownloadPodcast(context,data)
    }
}