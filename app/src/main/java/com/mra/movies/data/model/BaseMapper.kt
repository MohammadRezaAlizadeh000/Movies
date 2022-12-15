package com.mra.movies.data.model

interface BaseMapper<T, R> {
    suspend fun mapTo(data: T?): R?
}