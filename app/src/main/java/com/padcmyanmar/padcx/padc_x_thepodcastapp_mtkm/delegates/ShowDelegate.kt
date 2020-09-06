package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO

interface ShowDelegate {
    fun onTapItem(id : String)
    fun onTapDownloadPodcastItem(dataVO: DataVO)
}