package com.waffle.moviecomposeapp.base

import com.waffle.moviecomposeapp.domain.model.Popular

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}

sealed interface MovieUiState {
    data class Success(val movie: List<Popular>) : MovieUiState
    object Error : MovieUiState
    object Loading : MovieUiState
}