package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import kotlinx.android.synthetic.main.view_pod_play_back.view.*

class PlayBackViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


//    protected lateinit var mediaPlayer: MediaPlayer
//    private var startTime = 0
//    private var finalTime = 0
//    private var leftTime = 0

    override fun onFinishInflate() {
        super.onFinishInflate()


    }


    fun setData(episode: RandomVO) {
        Glide.with(this)
            .load(episode.image)
            .into(iv_play_back)

        tv_play_title.text = episode.title
        tv_play_description.text = episode.description

//        mediaPlayer = MediaPlayer().apply {
//            setAudioAttributes(
//                AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_MEDIA)
//                    .build()
//            )
//            setDataSource(episode.audio)
//            prepare()
//            start()
//        }
//         finalTime=mediaPlayer.duration/360
//         startTime = mediaPlayer.currentPosition/360
//         leftTime = finalTime-startTime
//        tv_left.text=leftTime.toString()+" h left"

    }
}