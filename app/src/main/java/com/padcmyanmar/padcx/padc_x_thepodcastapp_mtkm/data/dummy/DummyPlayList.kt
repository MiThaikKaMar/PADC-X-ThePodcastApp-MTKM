package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO

fun getPlayListVO() : List<PlaylistVO>{
    val data1 = PlaylistVO()
    val data2 = PlaylistVO()
    return listOf(data1,data2)
}