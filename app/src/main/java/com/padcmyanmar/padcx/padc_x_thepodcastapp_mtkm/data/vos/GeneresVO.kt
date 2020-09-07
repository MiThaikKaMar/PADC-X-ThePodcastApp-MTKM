package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genres_entity")
data class GeneresVO(
    @PrimaryKey
    @SerializedName("id")var id: Int=0,
    @SerializedName("name")var name: String="",
    @SerializedName("parent_id")var parent_id: Int=0,
    @SerializedName("image")var image: String=""
)