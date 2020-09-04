package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impl

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.CategoriesPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.PodcastPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class CategoriesPresenterImplTest {

    private lateinit var mCategoriesPresenter : CategoriesPresenterImpl
    @RelaxedMockK
    private lateinit var mCategoriesView : CategoriesView
    private lateinit var mPodcastModel : PodcastModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PodcastModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        
    }
}