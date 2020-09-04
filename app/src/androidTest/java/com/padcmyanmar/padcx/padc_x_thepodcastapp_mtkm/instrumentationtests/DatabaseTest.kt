package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.dao.PodcastDao
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.db.PodcastDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var db : PodcastDatabase
    private lateinit var dao : PodcastDao

    @Before
    fun setUpDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,PodcastDatabase::class.java).build()
        dao=db.podcastDao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun dataBaseTest(){
        var podcast = PlaylistVO()
        podcast.id= 1
        podcast.type="Art & Design"
        podcast.notes="detail_note"

        var podcast1 = PlaylistVO()
        podcast.id= 2
        podcast.type="Art & Design"
        podcast.notes="detail_note"

        dao.setPlayList(listOf(podcast,podcast1))
        assert(dao.getDetailById(podcast.id.toString()).value?.id == podcast.id)
    }

}