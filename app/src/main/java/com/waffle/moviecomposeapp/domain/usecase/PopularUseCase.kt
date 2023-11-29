package com.waffle.moviecomposeapp.domain.usecase

import android.util.Log
import com.waffle.moviecomposeapp.base.MovieUiState
import com.waffle.moviecomposeapp.base.Resource
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.domain.repository.PopularRepository
import kotlinx.coroutines.flow.Flow

class PopularUseCase(private val popularRepository: PopularRepository) {

    suspend fun getAllPopular() : MovieUiState {
        return popularRepository.getAllPopular()
    }

    fun getPopularFavorite() : MovieUiState {
        return popularRepository.getPopularFavorite()
    }

    suspend fun updatePopularFavorite(popular: Popular) {
        popularRepository.updatePopularFavorite(popular)
    }
}