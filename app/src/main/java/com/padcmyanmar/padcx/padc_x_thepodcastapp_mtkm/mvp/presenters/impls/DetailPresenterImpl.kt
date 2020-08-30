package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onClickBack() {
        mView?.finishActivity()
    }

}