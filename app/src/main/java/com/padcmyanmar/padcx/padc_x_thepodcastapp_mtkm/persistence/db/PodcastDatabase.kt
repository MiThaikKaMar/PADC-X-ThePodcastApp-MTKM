package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.*
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.dao.PodcastDao
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.DATABASE_NAME


@Database(entities =[GeneresVO::class,RandomVO::class,PlaylistVO::class,DetailVO::class,DownloadVO::class] ,
version =17 ,
exportSchema = false)
abstract class PodcastDatabase : RoomDatabase() {
    companion object {

        var dbInstance: PodcastDatabase? = null

        fun getDBInstance(context: Context): PodcastDatabase {
            when (dbInstance) {
                null -> {
                    dbInstance =
                        Room.databaseBuilder(context, PodcastDatabase::class.java, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }
    abstract fun podcastDao() : PodcastDao
}