package com.waffle.moviecomposeapp.data

import android.provider.ContactsContract.Data
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.waffle.moviecomposeapp.base.ApiResponse
import com.waffle.moviecomposeapp.base.MovieUiState
import com.waffle.moviecomposeapp.base.Resource
import com.waffle.moviecomposeapp.data.local.LocalDataSource
import com.waffle.moviecomposeapp.data.remote.RemoteDataSource
import com.waffle.moviecomposeapp.data.remote.response.ResultsItemPopular
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.domain.repository.PopularRepository
import com.waffle.moviecomposeapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.math.log

class AppRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    PopularRepository {

    override suspend fun getAllPopular(): MovieUiState {
        return try {
            MovieUiState.Loading
            val result = remoteDataSource.getAllPopular()
            if (result.isNotEmpty()) {
                val local = DataMapper.mapResponsesToEntities(result)
                localDataSource.insertPopular(local)
                val data = DataMapper.mapEntitiesToDomain(localDataSource.getLocalPopular())
                MovieUiState.Success(data)
            } else {
                MovieUiState.Error
            }
        } catch (e: Exception) {
            Log.e("TAG", "getAllPopular: $e", )
            MovieUiState.Error
        }
    }


    override fun getPopularFavorite(): MovieUiState {
        return try {
            MovieUiState.Loading
            val result = localDataSource.getPopularFavorite()
            if (result.isNotEmpty()) {
                MovieUiState.Success(DataMapper.mapEntitiesToDomain(result))
            } else {
                MovieUiState.Error
            }

        } catch (e: Exception) {
            MovieUiState.Error
        }

    }

    override suspend fun updatePopularFavorite(popular: Popular) {
        localDataSource.updatePopular(DataMapper.mapDomainToEntity(popular))
    }


}