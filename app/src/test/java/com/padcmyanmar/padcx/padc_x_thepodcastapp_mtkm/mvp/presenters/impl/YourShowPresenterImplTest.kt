package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getDownloadList
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getDownloadVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.MockPodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.CategoriesPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.YourShowPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.YourShowView
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
class YourShowPresenterImplTest {

    private lateinit var mYourShowPresenter : YourShowPresenterImpl
    @RelaxedMockK
    private lateinit var mYourShowView : YourShowView
    private lateinit var mPodcastModel : PodcastModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PodcastModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mPodcastModel = MockPodcastModelImpl
        mYourShowPresenter= YourShowPresenterImpl()
        mYourShowPresenter.initPresenter(mYourShowView)
        mYourShowPresenter.mPodcastModel=this.mPodcastModel
    }

    @Test
    fun onUiReady_callDisplayDownloadList(){

        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mYourShowPresenter.onUiReady(lifecycleOwner,"1")
        verify {
            mYourShowView.displayDownloadPodcastList(getDownloadList())
        }
    }

    @Test
    fun onTapDownloadListItem_callNavigateDetail(){
        mYourShowPresenter.onTapDownloadListItem(getDownloadVO())
        verify {
            mYourShowView.navigateDetail(getDownloadVO())
        }
    }
}