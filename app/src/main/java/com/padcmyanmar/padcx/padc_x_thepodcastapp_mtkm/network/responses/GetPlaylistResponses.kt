package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO

data class GetPlaylistResponses(
    @SerializedName("description")var description: String,
    @SerializedName("id")var id: String,
    @SerializedName("image")var image: String,
    @SerializedName("items")var items: List<PlaylistVO>,
    @SerializedName("last_timestamp_ms")var last_timestamp_ms: Long,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("name")var name: String,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("total")var total: Int,
    @SerializedName("type")var type: String,
    @SerializedName("visibility")var visibility: String
)