package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters

import android.content.Context
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.PodcastView
import com.padcmyanmar.padcx.shared.mvp.presenters.BasePresenter
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

interface PodcastPresenter :BasePresenter<PodcastView>, ShowDelegate {

    fun onClickDownload(context: Context,data : DataVO)

}