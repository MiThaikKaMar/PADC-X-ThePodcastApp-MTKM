package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.widget.*
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import kotlinx.android.synthetic.main.view_pod_mini_play_back.view.*
import kotlinx.android.synthetic.main.view_pod_mini_play_back.view.tv_mini_1x
import kotlinx.android.synthetic.main.view_pod_play_back.view.*

class MiniPlayBackViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private lateinit var mAudioUri : String

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setMiniData(detail: DetailVO) {
        mAudioUri= detail.audio
    }

    fun getPlayPauseImage() : ImageView {
        return iv_mini_play_pause
    }
    fun getTotalTimeLabel() : TextView {
        return tv_mini_left_time
    }
    fun getSeekBar() : SeekBar
    {
        return seek_bar_mini_play
    }
    fun getCurrentTimeLabel() : TextView {
        return tv_mini_finish_time
    }

    fun setUpData(audioUrl: String) {
        mAudioUri=audioUrl
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        iv_mini_next.setOnClickListener { mDelegate?.onTouchThirtySec() }
        iv_mini_previous.setOnClickListener { mDelegate?.onTouchFifteenSec() }
        iv_mini_play_pause.setOnClickListener { mDelegate?.onTouchPlayPause(mAudioUri) }
    }

    interface Delegate {
        fun onTouchPlayPause(mAudioUri: String)
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }

}

