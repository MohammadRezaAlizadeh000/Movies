package com.mra.movies.data

import com.mra.movies.model.MovieEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getPopularMovies(): Flow<List<MovieEntity>>

    suspend fun insertPopularMoviesToDB(movies: List<MovieEntity?>?): Boolean
}