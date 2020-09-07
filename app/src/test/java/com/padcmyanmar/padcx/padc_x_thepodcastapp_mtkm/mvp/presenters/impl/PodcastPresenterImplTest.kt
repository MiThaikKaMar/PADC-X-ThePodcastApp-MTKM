package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getDummyDataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getDummyRandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getPlayListVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.MockPodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.CategoriesPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.PodcastPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.PodcastView
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
class PodcastPresenterImplTest {

    private lateinit var mPodcastPresenter : PodcastPresenterImpl
    @RelaxedMockK
    private lateinit var mPodcastView : PodcastView
    private lateinit var mPodcastModel : PodcastModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PodcastModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mPodcastModel = MockPodcastModelImpl
        mPodcastPresenter= PodcastPresenterImpl()
        mPodcastPresenter.initPresenter(mPodcastView)
        mPodcastPresenter.mPodcastModelImpl=this.mPodcastModel
    }

    @Test
    fun onUiReady_callRandom_callPlayList(){

        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPodcastPresenter.onUiReady(lifecycleOwner,"1")
        verify {
            mPodcastView.showRandomEpisode(getDummyRandomVO())
            mPodcastView.displayPlayList(getPlayListVO())
        }
    }

    @Test
    fun onTapItem_callNavigateDetail(){
        mPodcastPresenter.onTapItem("1")
        verify {
            mPodcastView.navigateToDetailScreen("1")
        }
    }

//    @Test
//    fun onTapDownloadItem_callSaveDownloadItem(){
//        mPodcastPresenter.onTapDownloadPodcastItem(getDummyDataVO())
//        verify {
//            mPodcastView.selectedDownloadItem(getDummyDataVO())
//        }
//    }

    @Test
    fun onTapPlayPause_callOnTapPlayIcon(){
        mPodcastPresenter.onTouchPlayPause("https://cdn-images-1.listennotes.com/podcasts/exponent-ben-thompson-james-allworth-OaJSjb4xQv3.1400x1400.jpg")
        verify {
            mPodcastView.onTouchPlayPauseImage("https://cdn-images-1.listennotes.com/podcasts/exponent-ben-thompson-james-allworth-OaJSjb4xQv3.1400x1400.jpg"
            )
        }
    }

    @Test
    fun onTapFifteenSec_callOnTapFiteenIcon(){
        mPodcastPresenter.onTouchFifteenSec()
        verify {
            mPodcastView.onTouchBackwardFifteenSecIcon()
        }
    }

    @Test
    fun onTapThirtySec_callonTapThirtyIcon(){
        mPodcastPresenter.onTouchThirtySec()
        verify {
            mPodcastView.onTouchForwardThirtySecIcon()
        }
    }

}