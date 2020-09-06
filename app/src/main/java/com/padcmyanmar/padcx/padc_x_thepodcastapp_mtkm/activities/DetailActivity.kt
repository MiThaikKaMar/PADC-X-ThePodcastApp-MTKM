package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities

import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.DetailPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.DOWNLOADPAGE
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.PLAYER_TYPE_FILE
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.PLAYER_TYPE_STREAMING
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.MiniPlayBackViewPod
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.PlayBackViewPod
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_podcast.*
import mk.padc.share.utils.verifyAvailableNetwork
import mk.podcast.com.medias.MyMediaPlayerHelper
import java.util.concurrent.TimeUnit

class DetailActivity : AppCompatActivity(),DetailView {


    private var initPlayer = false
    private lateinit var mDetailPresenter : DetailPresenter
    private lateinit var mMiniViewPod : MiniPlayBackViewPod

    companion object{
        const val EPISODE_PARAM = "dataId"
        const val FROMPAGE ="fromPage"
        const val DOWNLOAD_AUDI_FILE_PATH ="audio_file_path"

        fun newIntent(context: Context, dataId: String, fromPage : String, assetFilePath : String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EPISODE_PARAM, dataId)
            intent.putExtra(FROMPAGE, fromPage)
            intent.putExtra(DOWNLOAD_AUDI_FILE_PATH, assetFilePath)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var detailId = intent.getStringExtra(EPISODE_PARAM)

        setUpPresenter()
        mDetailPresenter.onUiReady(this, detailId.toString())

        setUpListener()
        setUpViewPod()
    }

    private fun setUpListener() {
        iv_back.setOnClickListener {
            mDetailPresenter.onClickBack()
            onBackPressed()
        }
    }

    private fun setUpPresenter(){
        mDetailPresenter=ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }

    override fun finishActivity() {

    }
    private fun setUpViewPod(){
        mMiniViewPod= vp_mini_play as MiniPlayBackViewPod
        mMiniViewPod.setDelegate(mDetailPresenter)
    }

    override fun showDetail(detail: DetailVO) {

            Glide.with(this)
                .load(detail.image)
                .into(iv_detail)

            tv_detail_title.text=detail.title
            tv_detail_time.text=detail.audio_length_sec.toString()+"s"
            tv_detail_description.text=Html.fromHtml(detail.description)

            mMiniViewPod.setMiniData(detail)

    }

    override fun onTouchPlayPauseIcon(audioUri: String) {
        if (intent.getStringExtra(FROMPAGE).toString().equals(DOWNLOADPAGE)) {
            // If download fragment pass, no need to check intentert connection
            mediaPlayerSetup(audioUri)
        } else {
            //if other fragment pass, need to check internet connection ,  this case to solve offline open player gerbage time data
            if (!verifyAvailableNetwork(this)) {
                Toast.makeText(this, "Please Check Internet Connection , This is streaming type", Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayerSetup(audioUri)
            }
        }
    }

    fun mediaPlayerSetup(audioUri: String) {
        if (!initPlayer) {

            var type = PLAYER_TYPE_STREAMING
            var mAudioUrl = audioUri

            // If download fragment pass, media player require download audio filepath
            if (intent.getStringExtra(FROMPAGE).toString().equals(DOWNLOADPAGE)) {
                type = PLAYER_TYPE_FILE
                mAudioUrl = intent.getStringExtra(DOWNLOAD_AUDI_FILE_PATH).toString()
            }
            // First time media player initialization , fix duplicate player create case
            MyMediaPlayerHelper.initMediaPlayer(
                this, mAudioUrl,
                mMiniViewPod.getSeekBar(),
                mMiniViewPod.getPlayPauseImage(),
                mMiniViewPod.getCurrentTimeLabel(),
                mMiniViewPod.getTotalTimeLabel(), type
            )
            initPlayer = true
        } else {
            //  touch event player play pause toggle
            MyMediaPlayerHelper.playPauseMediaPlayBack(this)
        }
    }

    override fun onTouchForwardThirtySecIcon() {
        MyMediaPlayerHelper.forwardMediaPlayBack(this)
    }

    override fun onTouchBackwardFifteenSecIcon() {
        MyMediaPlayerHelper.backwardMediaPlayBack(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (initPlayer) MyMediaPlayerHelper.closeMediaPlayBack(this)
    }
}