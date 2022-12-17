package com.mra.movies.domin

import com.mra.movies.data.Repository
import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopularMoviesUseCase {
    suspend operator fun invoke(startPoint: Int, isOnline: Boolean): Flow<ResponseState<List<MovieEntity>>>
}

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: Repository
): GetPopularMoviesUseCase {
    override suspend fun invoke(startPoint: Int, isOnline: Boolean): Flow<ResponseState<List<MovieEntity>>> {
        return repository.getPopularMovies(startPoint, isOnline = isOnline)
    }

}