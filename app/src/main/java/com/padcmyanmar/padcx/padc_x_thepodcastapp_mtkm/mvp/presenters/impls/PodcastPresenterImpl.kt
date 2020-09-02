package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
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
                    mView?.showPlayList(it)
                }
            })
    }



    override fun onTapItem(id :String) {
        mView?.navigateDetail(id)
    }
}