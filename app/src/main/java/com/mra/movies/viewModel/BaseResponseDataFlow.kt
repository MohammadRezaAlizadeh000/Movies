package com.mra.movies.viewModel

interface BaseResponseDataFlow<T> {
    val errorMessage: String?
    val page: Int?
    val data: T?
}