package com.mra.movies.domin

import com.mra.movies.data.Repository
import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState
import javax.inject.Inject

interface GetPopularMoviesUseCase {
    suspend operator fun invoke(): ResponseState<List<MovieEntity?>?>?
}

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: Repository
): GetPopularMoviesUseCase {
    override suspend fun invoke(): ResponseState<List<MovieEntity?>?>? {
        TODO()
    }

}