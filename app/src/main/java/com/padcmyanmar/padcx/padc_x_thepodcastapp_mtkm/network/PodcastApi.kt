package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.network

import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.network.responses.GetGenresResponses
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.network.responses.GetPlaylistResponses
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastApi {

    @GET(GET_GENRES_LIST)
    fun getGenresList(
        @Header(PARAM_API_KEY) apiKey: String,
        @Query(PARAM_TOP_LEVEL_ONLY) top_level_only: Int
    )
            : Observable<GetGenresResponses>

    @GET(GET_RAMDOM)
    fun getRandomEpisode(@Header(PARAM_API_KEY) apiKey: String)
            : Observable<RandomVO>

    @GET(GET_PLAYLIST)
    fun getPlayList(@Path("PODCAST_ID") id: String,
    @Query(PARAM_TYPE) type:String,
    @Query(PARAM_LAST_TIMESTAMP) last:Int,
    @Query(PARAM_SORT) sort:String,
                    @Header(PARAM_API_KEY) apiKey: String): Observable<GetPlaylistResponses>

    @GET(GET_DETAIL)
    fun getDetail(@Path("DETAIL_ID")detailId : String,
    @Header(PARAM_API_KEY)apiKey: String):Observable<DetailVO>

}