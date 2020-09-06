package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.Toast
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import kotlinx.android.synthetic.main.view_pod_mini_play_back.view.*
import kotlinx.android.synthetic.main.view_pod_mini_play_back.view.tv_mini_1x
import kotlinx.android.synthetic.main.view_pod_play_back.view.*

class MiniPlayBackViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable:Runnable

    private var pause:Boolean = false

    private var myUrl = context.getString(R.string.my_url_string)

    override fun onFinishInflate() {
        super.onFinishInflate()

        var handler= Handler(Looper.getMainLooper())
        mediaPlayer = MediaPlayer.create(this.context, Uri.parse(myUrl))
//        mediaPlayer.start()
        // Start the media player
        iv_mini_play_pause.setOnClickListener {
            if (pause) {
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false

                Toast.makeText(this.context, "media playing", Toast.LENGTH_SHORT).show()
            } else {

                mediaPlayer.start()
                Toast.makeText(this.context,"media playing", Toast.LENGTH_SHORT).show()

            }
            initializeSeekBar()
            iv_mini_play_pause.isEnabled = false
            tv_mini_1x.isEnabled = true
        

            mediaPlayer.setOnCompletionListener {
                iv_mini_play_pause.isEnabled = true
                tv_mini_1x.isEnabled = false
                Toast.makeText(this.context, "end", Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        tv_mini_1x.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                pause = true

                iv_mini_play_pause.isEnabled = true
                tv_mini_1x.isEnabled = false

                Toast.makeText(this.context,"media pause", Toast.LENGTH_SHORT).show()
            }
        }



        // Seek bar change listener
        seek_bar_mini_play.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

    }

    fun setMiniData(detail : DetailVO){


    }

    @SuppressLint("SetTextI18n")
    private fun initializeSeekBar() {
        seek_bar_mini_play.max = mediaPlayer.seconds

        runnable = Runnable {
            seek_bar_mini_play.progress = mediaPlayer.currentSeconds

            tv_mini_finish_time.text = "${mediaPlayer.currentSeconds} sec"
            val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
            tv_mini_left_time.text = "$diff sec left"

//            handler.postDelayed(runnable, 1000)
        }
//        handler.postDelayed(runnable, 1000)
    }

    // Creating an extension property to get the media player time duration in seconds
    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }
    // Creating an extension property to get media player current position in seconds
    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition / 1000
        }
}

