package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.YourShowView
import com.padcmyanmar.padcx.shared.mvp.presenters.BasePresenter

interface YourShowPresenter : BasePresenter<YourShowView>, ShowDelegate {
}