package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "random_entity")
data class RandomVO(

    @SerializedName("audio")var audio: String="",
    @SerializedName("audio_length_sec")var audio_length_sec: Int=0,
    @SerializedName("description")var description: String="",
    @SerializedName("explicit_content")var explicit_content: Boolean=false,
    @SerializedName("id")var id: String="",
    @SerializedName("image")var image: String="",
    @PrimaryKey
    @SerializedName("link")var link: String="",
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String="",
    @SerializedName("listennotes_url")var listennotes_url: String="",
    @SerializedName("maybe_audio_invalid")var maybe_audio_invalid: Boolean=false,
    @Embedded
    @SerializedName("podcast")var podcast:PodcastVO? = null,
    @SerializedName("pub_date_ms")var pub_date_ms: Long=0,
    @SerializedName("thumbnail")var thumbnail: String="",
    @SerializedName("title")var title: String=""
)

data class PodcastVO(
    @SerializedName("id")var id1: String="",
    @SerializedName("image")var image1: String="",
    @SerializedName("listennotes_url")var listennotes_url1: String="",
    @SerializedName("publisher")var publisher: String="",
    @SerializedName("thumbnail")var thumbnail1: String="",
    @SerializedName("title")var title1: String=""
)