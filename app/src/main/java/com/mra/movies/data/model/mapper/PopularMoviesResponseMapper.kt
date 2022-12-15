package com.mra.movies.data.model.mapper

import com.mra.movies.data.model.BaseMapper
import com.mra.movies.data.model.PopularMoviesResponseModel
import com.mra.movies.model.MovieEntity

object PopularMoviesResponseMapper:
    BaseMapper<PopularMoviesResponseModel, List<MovieEntity>> {
    override suspend fun mapTo(data: PopularMoviesResponseModel?): List<MovieEntity>? {
        return data?.items?.map { responseData ->
            MovieEntity(
                responseData.id!!,
                responseData.rank,
                responseData.title,
                responseData.year,
                responseData.image,
                responseData.crew,
                responseData.imDbRating,
                responseData.imDbRatingCount
            )
        }
    }

}