package com.mra.movies.di

import android.content.Context
import androidx.room.Room
import com.mra.movies.model.DBContract.DATABASE_NAME
import com.mra.movies.view.DB.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MoviesDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun providePopularMovieDao(database: MoviesDatabase) = database.accessPopularMovieDao()

//    @Singleton
//    @Provides
//    fun provideSingleMovieDao(database: MoviesDatabase) = database.accessSingleMovieDao()

}