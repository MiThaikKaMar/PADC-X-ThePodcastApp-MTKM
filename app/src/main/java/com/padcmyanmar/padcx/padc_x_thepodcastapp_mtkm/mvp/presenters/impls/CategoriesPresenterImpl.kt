package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.CategoriesPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView


class CategoriesPresenterImpl : CategoriesPresenter ,AbstractBasePresenter<CategoriesView>() {

    var mPodcastModelImpl : PodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,id:String) {
        mPodcastModelImpl.getGenresListFromApiAndSaveDB(onError = {})

        requestGenresList(lifecycleOwner)
    }

    private fun requestGenresList(lifecycleOwner: LifecycleOwner){
        mPodcastModelImpl.getGenresList().observe(lifecycleOwner,Observer {
            it?.let {
                mView?.showGenresList(it)
                mView?.showMainCategory(it)
            }
        })
    }
}