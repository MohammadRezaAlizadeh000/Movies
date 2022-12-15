package com.mra.movies.utils

sealed class ResponseState<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?, message: String? = null): ResponseState<T>(data)
    class Error<T>(data: T? = null, message: String?): ResponseState<T>(data, message)
    class Loading<T>: ResponseState<T>()

}
