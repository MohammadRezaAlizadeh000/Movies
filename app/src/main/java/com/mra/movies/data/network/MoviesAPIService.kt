package com.mra.movies.data.network

import com.mra.movies.data.model.PopularMoviesResponseModel
import com.mra.movies.utils.API_KEY
import ir.mralizade.imdbshow.data.network.RequestParamKeys
import ir.mralizade.imdbshow.data.network.SingleMovieEndpoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPIService {

    @GET(HomeEndPointList.MOST_POPULAR_MOVIE)
    suspend fun getPopularMovies(
        @Path(RequestParamKeys.API_KEY_PARAM_KEY) apiKey: String = API_KEY
    ): Response<PopularMoviesResponseModel>

    @GET(SingleMovieEndpoints.SINGLE_MOVIE_DATA)
    suspend fun getSingleMovie(
        @Path(RequestParamKeys.ID_PARAM_KEY) movieId: String,
        @Path(RequestParamKeys.API_KEY_PARAM_KEY) apiKey: String = API_KEY
    ): Response<PopularMoviesResponseModel.MovieData>

}