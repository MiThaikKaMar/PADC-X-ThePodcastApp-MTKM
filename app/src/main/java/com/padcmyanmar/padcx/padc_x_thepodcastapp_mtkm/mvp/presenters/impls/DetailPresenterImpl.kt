package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    var mPodcastModel :PodcastModel = PodcastModelImpl
    var list : List<DetailVO> = listOf()

    override fun onUiReady(lifecycleOwner: LifecycleOwner,id:String) {
        mPodcastModel.getDetailFromApiAndSaveDB(id,onSuccess = {},onError = {})

        requestDetail(lifecycleOwner,id)
    }

    override fun onTouchPlayPause(audioUri : String) {
        mView?.onTouchPlayPauseIcon(audioUri)
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }

    private fun requestDetail(lifecycleOwner: LifecycleOwner, id: String) {
//        mPodcastModel.getDeatil(id)
//            .observe(lifecycleOwner, Observer {
//                it?.let {
//                    mView?.showDetail(it)
//                    Log.e("Id",it.id)
//                }
//            })
        mPodcastModel.getDetailById(id)
            .observe(lifecycleOwner, Observer() {
                it?.let {
                    it.data?.title?.let { it1 -> Log.e("title", it1) }
                    mView?.showDetail(it)
                }
            })
    }

    override fun onClickBack() {
        mView?.finishActivity()
    }

}