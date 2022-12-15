package com.mra.movies.data

import com.mra.movies.data.model.mapper.PopularMoviesResponseMapper
import com.mra.movies.data.network.MoviesAPIService
import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState
import com.mra.movies.utils.toResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: MoviesAPIService
) : RemoteDataSource {

    override suspend fun getPopularMovies(isOnline: Boolean): ResponseState<List<MovieEntity>> =
        withContext(Dispatchers.IO) {
            return@withContext apiService.getPopularMovies()
                .toResponseState(isOnline, PopularMoviesResponseMapper)
        }
}