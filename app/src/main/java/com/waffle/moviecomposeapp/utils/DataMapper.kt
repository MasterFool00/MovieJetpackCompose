package com.waffle.moviecomposeapp.utils

import com.waffle.moviecomposeapp.data.local.entity.PopularEntity
import com.waffle.moviecomposeapp.data.remote.response.ResultsItemPopular
import com.waffle.moviecomposeapp.domain.model.Popular

object DataMapper {
    fun mapEntitiesToDomain(input: List<PopularEntity>): List<Popular> =
        input.map {
            Popular(
                id = it.id,
                name = it.name,
                date = it.date,
                popularity = it.popularity,
                star = it.star,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                overview = it.overview,
                isFavorite = it.isFavorite
            )
        }

    fun mapResponsesToEntities(input: List<ResultsItemPopular?>) =
        input.map {
            PopularEntity(
                id = it?.id ?: 0,
                name = it?.title,
                date = it?.releaseDate,
                popularity = it?.popularity,
                star = it?.voteAverage,
                posterPath = it?.posterPath,
                backdropPath = it?.backdropPath,
                overview = it?.overview,
                isFavorite = false
            )
        }

    fun mapDomainToEntity(input: Popular) = PopularEntity(
        id = input.id,
        name = input.name,
        date = input.date,
        popularity = input.popularity,
        star = input.star,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        overview = input.overview,
        isFavorite = input.isFavorite
    )
}