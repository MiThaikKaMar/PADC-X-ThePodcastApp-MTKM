package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreIdTypeConverter {
    @TypeConverter
    fun toString(idList : ArrayList<Int>?) : String{
        idList?.let {
            return Gson().toJson(idList)
        }
        return ""
    }

    @TypeConverter
    fun toIntList(intListJsonString : String?) : ArrayList<Int>{
        intListJsonString?.let {
            val intListType= object : TypeToken<ArrayList<Int>>(){}.type
            return Gson().fromJson(intListJsonString,intListType)
        }
        return arrayListOf()
    }
}