package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.PodcastPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.PodcastView

class PodcastPresenterImpl : PodcastPresenter,AbstractBasePresenter<PodcastView>() {


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onTapItem(id :Int) {
        mView?.navigateDetail(id)
    }
}