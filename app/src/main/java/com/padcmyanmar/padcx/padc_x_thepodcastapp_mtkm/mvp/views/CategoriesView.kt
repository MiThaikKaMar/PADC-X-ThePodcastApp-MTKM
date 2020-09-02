package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

interface CategoriesView : BaseView {
    fun showGenresList(genresList : List<GeneresVO>)
    fun showMainCategory(genresList: List<GeneresVO>)
}