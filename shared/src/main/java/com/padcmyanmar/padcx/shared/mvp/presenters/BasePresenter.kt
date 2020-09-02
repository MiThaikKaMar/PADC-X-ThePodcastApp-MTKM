package com.padcmyanmar.padcx.shared.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.shared.mvp.views.BaseView


interface BasePresenter<T : BaseView> {
    fun initPresenter(view : T)
    fun onUiReady(lifecycleOwner: LifecycleOwner,id : String)
}