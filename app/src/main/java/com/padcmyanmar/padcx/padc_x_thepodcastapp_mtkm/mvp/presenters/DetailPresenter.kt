package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView
import com.padcmyanmar.padcx.shared.mvp.presenters.BasePresenter

interface DetailPresenter :
    BasePresenter<DetailView> {
fun onClickBack()
}