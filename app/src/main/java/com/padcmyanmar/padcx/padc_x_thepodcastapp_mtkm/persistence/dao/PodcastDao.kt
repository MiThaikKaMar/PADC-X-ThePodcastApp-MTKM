package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.*

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

    @Query("SELECT * FROM playlist_entity WHERE data_id in (:id)")
    fun getDetailById(id : String):LiveData<PlaylistVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDetail(detail : DetailVO)

    @Query("SELECT * FROM detail_entity WHERE :id")
    fun getDetail(id:String):LiveData<DetailVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDownloadPodcastData(podcasts: DownloadVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDownloadPodCastList(podCast: List<DownloadVO>)

    @Query("select * from download_entity")
    fun getAllDownloadPodcastData(): LiveData<List<DownloadVO>>
}