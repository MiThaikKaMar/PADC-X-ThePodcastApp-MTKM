package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views

import com.padcmyanmar.padcx.shared.mvp.views.BaseView

interface PodcastView : BaseView {
    fun navigateDetail(id :Int)
}