package com.waffle.moviecomposeapp.data.local

import com.waffle.core.data.local.LocalDatabase
import com.waffle.moviecomposeapp.data.local.entity.PopularEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val localDatabase: LocalDatabase) {

    fun getLocalPopular(): List<PopularEntity> {
        return localDatabase.popularDao().getPopularList()
    }

    fun getPopularFavorite(): List<PopularEntity> {
        return localDatabase.popularDao().getPopularFavorite()
    }

    suspend fun insertPopular(input: List<PopularEntity>) =
        localDatabase.popularDao().insertPopularList(input)

    suspend fun updatePopular(input: PopularEntity) = localDatabase.popularDao().updatePopular(input)

}