package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padcx.shared.mvp.views.BaseView
import com.padcmyanmar.padcx.shared.mvp.presenters.BasePresenter

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>,ViewModel() {

    var mView : T? =null

    override fun initPresenter(view: T) {
        mView = view
    }
}