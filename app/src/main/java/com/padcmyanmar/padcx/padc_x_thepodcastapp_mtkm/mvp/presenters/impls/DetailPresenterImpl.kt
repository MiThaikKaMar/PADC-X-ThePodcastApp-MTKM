package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    protected val mPodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,id:String) {
        requestDetail(lifecycleOwner,id)
    }

    private fun requestDetail(lifecycleOwner: LifecycleOwner, id: String) {
        mPodcastModel.getDeatil(id,onSuccess = {
            mView?.showDetail(it)
        })
    }

    override fun onClickBack() {
        mView?.finishActivity()
    }

}