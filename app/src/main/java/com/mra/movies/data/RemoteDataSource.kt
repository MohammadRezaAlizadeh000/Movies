package com.mra.movies.data

import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState

interface RemoteDataSource {

    suspend fun getPopularMovies(isOnline: Boolean): ResponseState<List<MovieEntity>>
}