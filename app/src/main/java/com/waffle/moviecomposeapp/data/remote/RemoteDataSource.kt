package com.waffle.moviecomposeapp.data.remote

import com.waffle.moviecomposeapp.api.ApiService
import com.waffle.moviecomposeapp.base.ApiResponse
import com.waffle.moviecomposeapp.data.remote.response.ResultsItemPopular
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllPopular(): List<ResultsItemPopular?> {
        return apiService.getPopularList().body()?.results ?: listOf()
    }
}