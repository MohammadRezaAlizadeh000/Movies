package com.mra.movies.di

import com.mra.movies.domin.GetPopularMoviesUseCase
import com.mra.movies.domin.GetPopularMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesDI {

    @Binds
    abstract fun bindGetPopularMovies(impl: GetPopularMoviesUseCaseImpl): GetPopularMoviesUseCase
}