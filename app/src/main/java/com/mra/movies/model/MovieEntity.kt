package com.mra.movies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DBContract.MOVIES_TABLE_NAME)
data class MovieEntity(
    @PrimaryKey
    val movieId: String,
    val rank: String?,
    val title: String?,
    val year: String?,
    val posterUrl: String?,
    val crew: String?,
    val imDbRate: String?,
    val imDbRateCount: String?
)