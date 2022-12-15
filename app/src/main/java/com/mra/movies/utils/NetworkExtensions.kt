package com.mra.movies.utils

import com.mra.movies.data.model.BaseMapper
import retrofit2.Response

suspend fun <T, R> Response<T>.toResponseState(
    isOnline: Boolean,
    mapper: BaseMapper<T, R>
): ResponseState<R> {
    try {
        if (!this.isSuccessful)
            return ResponseState.Error(message = this.message())

        if (!isOnline)
            return ResponseState.Error(message = "Network Error")

        return if (this.body() != null) {
            when (this.code()) {
                404 -> ResponseState.Error(null, message = "Please try later")
                402 -> ResponseState.Error(null, message = "Authentication Error")
                in 300..399 -> ResponseState.Error(null, message = this.message())
                in 400..499 -> ResponseState.Error(null, message = this.message())
                in 500..599 -> ResponseState.Error(null, message = "Server note responding")
                else -> ResponseState.Success(
                    mapper.mapTo(this.body()),
                    message = "collect data successful"
                )
            }
        } else {
            ResponseState.Error(null, message = "System Error")
        }
    } catch (e: Exception) {
        return ResponseState.Error(null, message = e.message)
    }
}