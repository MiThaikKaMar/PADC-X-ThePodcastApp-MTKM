package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

interface YourShowView : BaseView {
fun navigateDetail(downloadVO: DownloadVO)
    fun displayDownloadPodcastList(list: List<DownloadVO>)
}