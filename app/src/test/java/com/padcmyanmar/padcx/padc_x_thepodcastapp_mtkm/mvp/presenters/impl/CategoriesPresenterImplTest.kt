package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getGenresVOList
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.MockPodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.CategoriesPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.PodcastPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
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
        mPodcastModel = MockPodcastModelImpl
        mCategoriesPresenter= CategoriesPresenterImpl()
        mCategoriesPresenter.initPresenter(mCategoriesView)
        mCategoriesPresenter.mPodcastModelImpl=this.mPodcastModel
    }

    @Test
    fun onUiReady_callShowGenresList(){
        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mCategoriesPresenter.onUiReady(lifecycleOwner,"")
        verify {
            mCategoriesView.showMainCategory(getGenresVOList())
            mCategoriesView.showGenresList(getGenresVOList())
        }
    }
}