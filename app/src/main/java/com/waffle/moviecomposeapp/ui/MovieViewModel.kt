package com.waffle.moviecomposeapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waffle.moviecomposeapp.base.MovieUiState
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.domain.usecase.PopularUseCase
import kotlinx.coroutines.launch

class MovieViewModel(private val useCase: PopularUseCase) : ViewModel() {

    var movieUiState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    var favoriteUiState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    fun getPopularList() {
        viewModelScope.launch {
            movieUiState = useCase.getAllPopular()
        }
    }

    fun getPopularFavorite() {
        viewModelScope.launch {
            favoriteUiState = useCase.getPopularFavorite()
        }
    }


    fun updatePopular(popular : Popular) {
        viewModelScope.launch {
            useCase.updatePopularFavorite(popular)
        }
    }
}