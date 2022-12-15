package com.mra.movies.data.model

data class PopularMoviesResponseModel(
    val errorMessage: String?,
    val items: List<MovieData>?
) {
    data class MovieData(
        val crew: String?,
        val fullTitle: String?,
        val id: String?,
        val imDbRating: String?,
        val imDbRatingCount: String?,
        val image: String?,
        val rank: String?,
        val rankUpDown: String?,
        val title: String?,
        val year: String?
    )
}