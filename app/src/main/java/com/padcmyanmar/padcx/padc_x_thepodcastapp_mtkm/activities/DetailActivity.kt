package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.DetailPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.DetailPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),DetailView {

    private lateinit var mDetailPresenter : DetailPresenter

    companion object{
        fun newIntent(context : Context,id :Int): Intent {
            return Intent(context,DetailActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpPresenter()

        setUpListener()
    }

    private fun setUpListener(){
        mDetailPresenter.onClickBack()
    }

    private fun setUpPresenter(){
        mDetailPresenter=ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }

    override fun finishActivity() {
        finish()
    }
}