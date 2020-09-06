package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods


import android.content.Context
import android.text.Html
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import kotlinx.android.synthetic.main.view_pod_play_back.view.*
import mk.padc.share.utils.load


class PlayBackViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private var mAudioUrl : String ?=null

    override fun onFinishInflate() {
        super.onFinishInflate()

        setUpListener()
    }


    fun setData(episode: RandomVO) {

        iv_play_back.load(episode.image)
        tv_play_title.text = episode.title
        tv_play_description.text = Html.fromHtml(episode.description)

        mAudioUrl = episode.audio

    }

    fun getPlayPauseImage() : ImageView {
        return iv_play_pause
    }
    fun getSeekBar() : SeekBar
    {
        return seek_bar_play
    }
    fun getRemainingTime() : TextView {
        return tv_time_left
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        iv_next.setOnClickListener { mDelegate?.onTouchThirtySec() }
        iv_previous.setOnClickListener { mDelegate?.onTouchFifteenSec() }

        iv_play_pause.setOnClickListener {
            mAudioUrl?.let { it1 -> mDelegate?.onTouchPlayPause(it1) }
        }
    }

    interface Delegate {
        fun onTouchPlayPause(audioUrl : String)
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }
}


