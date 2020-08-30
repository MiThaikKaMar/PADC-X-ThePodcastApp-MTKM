package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.MainPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.MainView

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>(){
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}