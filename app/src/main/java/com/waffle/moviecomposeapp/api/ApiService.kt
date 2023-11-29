package com.waffle.moviecomposeapp.api

import com.waffle.moviecomposeapp.data.remote.response.PopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularList(
        @Query("page") page : Int = 2
    ) : Response<PopularResponse>
}