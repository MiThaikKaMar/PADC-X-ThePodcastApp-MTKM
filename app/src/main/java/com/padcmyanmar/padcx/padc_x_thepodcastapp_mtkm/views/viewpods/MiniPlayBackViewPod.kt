package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import kotlinx.android.synthetic.main.view_pod_mini_play_back.view.*

class MiniPlayBackViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

//    protected lateinit var mediaPlayerMini: MediaPlayer
//    private var startTime = 0
//    private var finalTime = 0
//    private var leftTime = 0

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    fun setMiniData(detail : DetailVO){

//        mediaPlayerMini = MediaPlayer().apply {
//            setAudioAttributes(
//                AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_MEDIA)
//                    .build()
//            )
//            setDataSource(detail.audio)
//            prepare()
//        }
//        iv_mini_play_pause.setOnClickListener {
//            mediaPlayerMini.start()
//        }
//        finalTime=mediaPlayerMini.duration/360
//        startTime = mediaPlayerMini.currentPosition/360
//        leftTime = finalTime-startTime
//
//        tv_mini_finish_time.text=startTime.toString()+" h"
//        tv_mini_left_time.text=leftTime.toString()+" h "

    }
}