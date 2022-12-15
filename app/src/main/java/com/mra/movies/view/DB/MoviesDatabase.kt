package com.mra.movies.view.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mra.movies.model.DBContract.DATABASE_VERSION
import com.mra.movies.model.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = DATABASE_VERSION,
)
//@TypeConverters(SingleMovieTypeConverter::class)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun accessPopularMovieDao(): MoviesDAO
//    abstract fun accessSingleMovieDao(): SingleMovieDAO

}