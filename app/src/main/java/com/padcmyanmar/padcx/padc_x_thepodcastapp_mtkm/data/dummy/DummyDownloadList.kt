package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO

fun getDownloadList(): List<DownloadVO> {
    val data1 = DownloadVO("","","","","")
    val data2 = DownloadVO("","","","","")
return listOf(data1,data2)
}