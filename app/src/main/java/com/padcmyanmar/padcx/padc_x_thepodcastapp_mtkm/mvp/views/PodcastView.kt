package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

interface PodcastView : BaseView {
    fun navigateToDetailScreen(episodeID : String)
    fun showRandomEpisode(randomEpisode : RandomVO)

    fun displayPlayList(playList:List<PlaylistVO>)
    fun selectedDownloadItem(data: DataVO)

    fun onTouchPlayPauseImage(audioUrl : String)
    fun onTouchForwardThirtySecIcon()
    fun onTouchBackwardFifteenSecIcon()
}