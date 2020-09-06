//package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.Impls
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getGenresVOList
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.dummy.getPlayListVO
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.models.PodcastModel
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
//import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
//
//object MockPodcastModelImpl : PodcastModel {
//    override fun getGenresList(): LiveData<List<GeneresVO>> {
//        val liveData = MutableLiveData<List<GeneresVO>>()
//        liveData.postValue(getGenresVOList())
//        return liveData
//    }
//
//    override fun getRandomEpisode(): LiveData<RandomVO> {
//        val liveData = MutableLiveData<RandomVO>()
//        liveData.postValue(RandomVO())
//        return liveData
//
//    }
//
//    override fun getPlayList(): LiveData<List<PlaylistVO>> {
//        val liveData = MutableLiveData<List<PlaylistVO>>()
//        liveData.postValue(getPlayListVO())
//        return liveData
//    }
//
//    override fun getDeatil(detailId: String): LiveData<DetailVO> {
//        val liveData = MutableLiveData<DetailVO>()
//        liveData.postValue(DetailVO())
//        return liveData
//    }
//
//}