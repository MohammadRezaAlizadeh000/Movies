package com.mra.movies.data

import com.mra.movies.model.MovieEntity
import com.mra.movies.view.DB.MoviesDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val moviesDAO: MoviesDAO,
): LocalDataSource {

    override suspend fun getPopularMovies(): Flow<List<MovieEntity>> {
        return moviesDAO.getPopularMovies(1)
    }

    override suspend fun insertPopularMoviesToDB(movies: List<MovieEntity?>?): Boolean {
        return !moviesDAO.insertPopularMoviesToDB(movies).contains(-1)
    }
}