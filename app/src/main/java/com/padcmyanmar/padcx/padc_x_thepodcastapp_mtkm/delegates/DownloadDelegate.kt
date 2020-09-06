package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO

interface DownloadDelegate {
    fun onTapDownloadListItem(downloadVo: DownloadVO)
}