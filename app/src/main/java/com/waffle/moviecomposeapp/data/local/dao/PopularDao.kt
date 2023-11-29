package com.waffle.moviecomposeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.waffle.moviecomposeapp.data.local.entity.PopularEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PopularDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPopularList(list : List<PopularEntity>)

    @Query("SELECT * FROM popular_db")
    fun getPopularList() : List<PopularEntity>

    @Query("SELECT * FROM popular_db WHERE is_favorite == 1")
    fun getPopularFavorite() : List<PopularEntity>

    @Update
    suspend fun updatePopular(popular: PopularEntity)
}