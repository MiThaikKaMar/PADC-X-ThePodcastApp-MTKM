package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import android.os.Looper

import android.text.Html
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import kotlinx.android.synthetic.main.view_pod_play_back.view.*


class PlayBackViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable:Runnable

    private var pause:Boolean = false

    private var myUrl = context.getString(R.string.my_url_string)
    private lateinit var myUrlString : String

    override fun onFinishInflate() {
        super.onFinishInflate()

        var handler= Handler(Looper.getMainLooper())
        mediaPlayer = MediaPlayer.create(this.context, Uri.parse(myUrl))
//        mediaPlayer.start()
        // Start the media player
        iv_play_pause.setOnClickListener {
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
            iv_play_pause.isEnabled = false
            tv_1x.isEnabled = true
            tv_zz.isEnabled = true

            mediaPlayer.setOnCompletionListener {
                iv_play_pause.isEnabled = true
                tv_1x.isEnabled = false
                tv_zz.isEnabled = false
                Toast.makeText(this.context, "end", Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        tv_1x.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                pause = true

                iv_play_pause.isEnabled = true
                tv_1x.isEnabled = false
                tv_zz.isEnabled = true
                Toast.makeText(this.context,"media pause", Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
//        iv_stop.setOnClickListener{
//            if(mediaPlayer.isPlaying || pause.equals(true)){
//                pause = false
//                seek_bar_play.setProgress(0)
//                mediaPlayer.stop()
//                mediaPlayer.reset()
//                mediaPlayer.release()
//                handler.removeCallbacks(runnable)
//
//                iv_play_pause.isEnabled = true
//                tv_1x.isEnabled = false
//                tv_zz.isEnabled = false
////                tv_pass.text = ""
////                tv_left.text = ""
//                Toast.makeText(this.context,"media stop", Toast.LENGTH_SHORT).show()
//            }
//        }


        // Seek bar change listener
        seek_bar_play.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
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

    // Method to initialize seek bar and audio stats
    @SuppressLint("SetTextI18n")
    private fun initializeSeekBar() {
        seek_bar_play.max = mediaPlayer.seconds

        runnable = Runnable {
            seek_bar_play.progress = mediaPlayer.currentSeconds

//            tv_zz.text = "${mediaPlayer.currentSeconds} sec"
            val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
            tv_zz.text = "$diff sec left"

//            handler.postDelayed(runnable, 1000)
        }
//        handler.postDelayed(runnable, 1000)
    }

    fun setData(episode: RandomVO) {
        Glide.with(this)
            .load(episode.image)
            .into(iv_play_back)

        tv_play_title.text = episode.title
        tv_play_description.text = Html.fromHtml(episode.description)

        myUrlString= episode.audio

    }
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

