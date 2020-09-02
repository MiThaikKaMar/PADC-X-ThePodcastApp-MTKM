package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DetailVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO

@Dao
interface PodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setGenresList(genresList : List<GeneresVO>)

    @Query("SELECT * FROM genres_entity")
    fun getGenresList():LiveData<List<GeneresVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setRandomEpisode(randomEpisode : RandomVO)

    @Query("SELECT * FROM random_entity")
    fun getRandomEpisode():LiveData<RandomVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPlayList(list : List<PlaylistVO>)

    @Query("SELECT * FROM playlist_entity")
    fun getPlayList():LiveData<List<PlaylistVO>>

    @Query("SELECT * FROM playlist_entity WHERE :id")
    fun getDetailById(id : String):LiveData<PlaylistVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDetail(detail : DetailVO)

    @Query("SELECT * FROM detail_entity")
    fun getDetail():LiveData<DetailVO>
}