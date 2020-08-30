package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.CategoriesPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView

class CategoriesPresenterImpl : CategoriesPresenter ,AbstractBasePresenter<CategoriesView>() {


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}