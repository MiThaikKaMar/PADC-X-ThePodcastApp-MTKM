package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.YourShowPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.YourShowView

class YourShowPresenterImpl : YourShowPresenter, AbstractBasePresenter<YourShowView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner,id: String) {

    }

    override fun onTapItem(id: String) {
        mView?.navigateDetail(id)
    }
}