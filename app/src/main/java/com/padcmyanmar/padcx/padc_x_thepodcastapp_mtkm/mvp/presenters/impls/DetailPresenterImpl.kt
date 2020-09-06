package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    protected val mPodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,id:String) {
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


        mPodcastModel.getDeatil(id)
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.showDetail(it)
                }
            })
    }

    override fun onClickBack() {
        mView?.finishActivity()
    }

}