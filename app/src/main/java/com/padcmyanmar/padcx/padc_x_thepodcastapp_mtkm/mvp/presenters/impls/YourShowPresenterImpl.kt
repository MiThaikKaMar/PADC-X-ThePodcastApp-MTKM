package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.YourShowPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.YourShowView

class YourShowPresenterImpl : YourShowPresenter, AbstractBasePresenter<YourShowView>() {

  var mPodcastModel = PodcastModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner,id: String) {
        mPodcastModel.getDownloadPodcastList ( onError = {})
            .observe(lifecycleOwner, androidx.lifecycle.Observer {
                it?.let {
                    mView?.displayDownloadPodcastList(it)
                }
            })
    }

    override fun onTapDownloadListItem(downloadVo: DownloadVO) {
        mView?.navigateDetail(downloadVo)
    }

}