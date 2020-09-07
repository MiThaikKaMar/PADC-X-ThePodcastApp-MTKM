package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getDummyDetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.MockPodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls.PodcastModelImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.CategoriesPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.DetailPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.DetailView
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
class DetailPresenterImplTest {

    private lateinit var mDetailPresenter : DetailPresenterImpl
    @RelaxedMockK
    private lateinit var mDetailView : DetailView
    private lateinit var mPodcastModel : PodcastModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PodcastModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mPodcastModel = MockPodcastModelImpl
        mDetailPresenter= DetailPresenterImpl()
        mDetailPresenter.initPresenter(mDetailView)
        mDetailPresenter.mPodcastModel=this.mPodcastModel
    }

//    @Test
//    fun onUiReady_callShowDetail(){
//        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
//        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
//        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)
//
//        mDetailPresenter.onUiReady(lifecycleOwner,"1")
//        verify {
//            mDetailView.showDetail(getDummyDetailVO())
//        }
//    }

    @Test
    fun onTapPlayPause_callOnTapPlayIcon(){
        mDetailPresenter.onTouchPlayPause("https://cdn-images-1.listennotes.com/podcasts/exponent-ben-thompson-james-allworth-OaJSjb4xQv3.1400x1400.jpg")
        verify {
            mDetailView.onTouchPlayPauseIcon("https://cdn-images-1.listennotes.com/podcasts/exponent-ben-thompson-james-allworth-OaJSjb4xQv3.1400x1400.jpg"
            )
        }
    }

    @Test
    fun onTapFifteenSec_callOnTapFiteenIcon(){
        mDetailPresenter.onTouchFifteenSec()
        verify {
            mDetailView.onTouchBackwardFifteenSecIcon()
        }
    }

    @Test
    fun onTapThirtySec_callonTapThirtyIcon(){
        mDetailPresenter.onTouchThirtySec()
        verify {
            mDetailView.onTouchForwardThirtySecIcon()
        }
    }

    @Test
    fun onClickBack_callOnFinishActivity(){
        mDetailPresenter.onClickBack()
        verify {
            mDetailView.finishActivity()
        }
    }
}