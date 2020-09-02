package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities

import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.DetailPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.MiniPlayBackViewPod
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.PlayBackViewPod
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_podcast.*
import java.util.concurrent.TimeUnit

class DetailActivity : AppCompatActivity(),DetailView {



    private lateinit var mDetailPresenter : DetailPresenter
    private lateinit var mMiniViewPod : MiniPlayBackViewPod

    companion object{
        const val DETAIL_ID ="detail_id"
        fun newIntent(context : Context,id :String): Intent {
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra(DETAIL_ID,id)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var detailId = intent.getStringExtra(DETAIL_ID)

        setUpPresenter()
        mDetailPresenter.onUiReady(this, detailId.toString())

        setUpListener()
        setUpViewPod()
    }

    private fun setUpListener(){
        iv_back.setOnClickListener {
            mDetailPresenter.onClickBack()
        }
    }

    private fun setUpPresenter(){
        mDetailPresenter=ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }

    override fun finishActivity() {
        finish()
    }
    private fun setUpViewPod(){
        mMiniViewPod= vp_mini_play as MiniPlayBackViewPod

    }

    override fun showDetail(detail: DetailVO) {
        detail?.let {
            Glide.with(window.decorView)
                .load(it.image)
                .into(iv_detail)

            tv_detail_title.text=it.title
            tv_detail_time.text=it.audio_length_sec.toString()+" s"
            tv_detail_description.text=it.description

            mMiniViewPod.setMiniData(it)
        }
    }
}