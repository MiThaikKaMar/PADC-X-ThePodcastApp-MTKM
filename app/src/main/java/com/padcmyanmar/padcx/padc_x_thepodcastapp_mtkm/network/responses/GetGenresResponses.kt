package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO

data class GetGenresResponses(
    @SerializedName("genres")var genres: List<GeneresVO>? = listOf()
)