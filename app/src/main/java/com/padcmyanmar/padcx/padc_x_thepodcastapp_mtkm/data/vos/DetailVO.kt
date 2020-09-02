package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail_entity")
data class DetailVO(
    @SerializedName("audio")var audio: String,
    @SerializedName("audio_length_sec")var audio_length_sec: Int,
    @SerializedName("description")var description: String,
    @SerializedName("explicit_content")var explicit_content: Boolean,
    @PrimaryKey
    @SerializedName("id")var id: String,
    @SerializedName("image")var image: String,
    @SerializedName("link")var link: String,
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("maybe_audio_invalid")var maybe_audio_invalid: Boolean,
    @Embedded
    @SerializedName("podcast")var podcast: PodcastVO,
    @SerializedName("pub_date_ms")var pub_date_ms: Long,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String
)

data class Podcast(
    @SerializedName("country")var country: String,
    @SerializedName("description")var description: String,
    @SerializedName("earliest_pub_date_ms")var earliest_pub_date_ms: Long,
    @SerializedName("email")var email: String,
    @SerializedName("explicit_content")var explicit_content: Boolean,
    @SerializedName("extra")var extra: Extra,
    @SerializedName("genre_ids")var genre_ids: List<Int>,
    @SerializedName("id")var id: String,
    @SerializedName("image")var image: String,
    @SerializedName("is_claimed")var is_claimed: Boolean,
    @SerializedName("itunes_id")var itunes_id: Int,
    @SerializedName("language")var language: String,
    @SerializedName("latest_pub_date_ms")var latest_pub_date_ms: Long,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @Embedded
    @SerializedName("looking_for")var looking_for: LookingFor,
    @SerializedName("publisher")var publisher: String,
    @SerializedName("rss")var rss: String,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String,
    @SerializedName("total_episodes")var total_episodes: Int,
    @SerializedName("type")var type: String,
    @SerializedName("website")var website: String
)

data class LookingFor(
    @SerializedName("cohosts")var cohosts: Boolean,
    @SerializedName("cross_promotion")var cross_promotion: Boolean,
    @SerializedName("guests")var guests: Boolean,
    @SerializedName("sponsors")var sponsors: Boolean
)

data class Extra(
    @SerializedName("facebook_handle")var facebook_handle: String,
    @SerializedName("google_url")var google_url: String,
    @SerializedName("instagram_handle")var instagram_handle: String,
    @SerializedName("linkedin_url")var linkedin_url: String,
    @SerializedName("patreon_handle")var patreon_handle: String,
    @SerializedName("spotify_url")var spotify_url: String,
    @SerializedName("twitter_handle")var twitter_handle: String,
    @SerializedName("url1")var url1: String,
    @SerializedName("url2")var url2: String,
    @SerializedName("url3")var url3: String,
    @SerializedName("wechat_handle")var wechat_handle: String,
    @SerializedName("youtube_url")var youtube_url: String
)