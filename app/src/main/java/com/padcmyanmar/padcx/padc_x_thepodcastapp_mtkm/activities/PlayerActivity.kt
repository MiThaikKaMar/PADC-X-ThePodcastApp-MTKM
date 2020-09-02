//package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities
//
//import android.media.AudioAttributes
//import android.media.MediaPlayer
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.SeekBar
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
//import kotlinx.android.synthetic.main.activity_player.*
//import java.util.concurrent.TimeUnit
//
//class PlayerActivity : AppCompatActivity() {
//
//    private var startTime = 0
//    private var finalTime = 0
//
//    private val forwardTime = 30000
//    private val backwardTime = 15000
//
//    private var oneTimeOnly = 0
//    private lateinit var mediaPlayer: MediaPlayer
//
//    private var wasPlaying = false
//
//    private val myUrl = "https://www.listennotes.com/e/p/6a15b804507a4387bc51450bb173146f/"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_player)
//
//            playSong()
//
//
////        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
////            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
////                textView2.visibility=View.VISIBLE
////                var x = TimeUnit.MILLISECONDS.toMinutes(startTime.toLong())
////
////                if (mediaPlayer.isPlaying()) {
////                    clearMediaPlayer();
////                   button2.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24)
////                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
////                        seekbar?.setProgress(0,false)
////                    }
////                }
////            }
////
////            override fun onStartTrackingTouch(p0: SeekBar?) {
////                textView2.visibility= View.VISIBLE
////            }
////
////            override fun onStopTrackingTouch(seekBar: SeekBar?) {
////
////                if (mediaPlayer.isPlaying()) {
////                    seekBar?.progress?.let { mediaPlayer.seekTo(it) }
////                }
////            }
////
////        })
//
//    }
//
//    fun playSong() {
//
//
//        mediaPlayer= MediaPlayer().apply {
//            setAudioAttributes(
//                AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_MEDIA)
//                    .build()
//            )
//            setDataSource(myUrl)
//
//        }
//
//        if (mediaPlayer.isPlaying()) {
//           clearMediaPlayer()
//            wasPlaying = true
//            button2.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24)
//        }
//
//
//        if (!wasPlaying) {
//
//           button2.setBackgroundResource(R.drawable.ic_baseline_pause_circle_filled_24)
//
//
//            mediaPlayer.prepare()
//
//            finalTime=mediaPlayer.duration
//            startTime=mediaPlayer.currentPosition
//            seekBar.max=finalTime
//
//            textView2.text=startTime.toString()
//            textView3.text=finalTime.toString()
//
//            seekBar.progress=startTime
//        }
//        wasPlaying = false
//
//        mediaPlayer.prepare()
//        mediaPlayer.start()
//        }
//
//    fun clearMediaPlayer(){
//        mediaPlayer.stop()
//        mediaPlayer.release()
//    }
//
//    }
//
////    fun setUpPlayerAction() {
////        val mediaPlayer1: MediaPlayer? = MediaPlayer().apply {
////            setAudioAttributes(
////                AudioAttributes.Builder()
////                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
////                    .setUsage(AudioAttributes.USAGE_MEDIA)
////                    .build()
////            )
////            setDataSource(myUrl)
////            prepare()// might take long! (for buffering, etc)
////
////            startTime = duration ?: 0
////            finalTime = currentPosition ?: 0
////
////            if (oneTimeOnly == 0) {
////                seekBar.max = finalTime
////                oneTimeOnly = 1
////            }
////
////            textView2.text = String.format("", TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()))
////            textView3.text =
////                String.format(" m left", TimeUnit.MILLISECONDS.toMinutes(finalTime.toLong()))
////
////            seekBar.setProgress(startTime)
////
////            seekTo(seekBar.progress)
////            start()
////        }
//
//
//
//
//
//
