package com.mra.movies.data

import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getPopularMovies(
        startPoint: Int,
        isRefresh: Boolean = false,
        isOnline: Boolean
    ): Flow<ResponseState<List<MovieEntity>>>

//    suspend fun getSingleMovieData(movieId: String): Flow<ResponseState<MovieEntity>>

}