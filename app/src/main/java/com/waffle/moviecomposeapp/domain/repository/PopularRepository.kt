package com.waffle.moviecomposeapp.domain.repository

import com.waffle.moviecomposeapp.base.MovieUiState
import com.waffle.moviecomposeapp.base.Resource
import com.waffle.moviecomposeapp.domain.model.Popular
import kotlinx.coroutines.flow.Flow

interface PopularRepository {
    suspend fun getAllPopular(): MovieUiState
    fun getPopularFavorite() : MovieUiState
    suspend fun updatePopularFavorite(popular: Popular)
}