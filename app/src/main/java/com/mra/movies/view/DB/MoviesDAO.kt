package com.mra.movies.view.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mra.movies.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMoviesToDB(popularMovie: List<MovieEntity?>?): List<Long>

    @Query("SELECT * FROM popular_movies LIMIT :startPoint, 20")
    fun getPopularMovies(startPoint: Int): Flow<List<MovieEntity>>
//
//    @Query("DELETE FROM popular_movies")
//    suspend fun clearDatabase()

}