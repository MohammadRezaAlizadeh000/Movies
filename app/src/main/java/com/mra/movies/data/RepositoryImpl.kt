package com.mra.movies.data

import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getPopularMovies(
        startPoint: Int,
        isRefresh: Boolean,
        isOnline: Boolean
    ): Flow<ResponseState<List<MovieEntity>>> = flow {
        localDataSource.getPopularMovies(startPoint).collect { localData ->
            if (localData.isNotEmpty()) {
                emit(ResponseState.Success(data = localData))

//                when (val remoteData = remoteDataSource.getPopularMovies(isOnline)) {
//                    is ResponseState.Success -> localDataSource.insertPopularMoviesToDB(remoteData.data)
//                    else -> emit(remoteData)
//                }
            } else {
                when (val remoteData = remoteDataSource.getPopularMovies(isOnline)) {
                    is ResponseState.Success -> localDataSource.insertPopularMoviesToDB(remoteData.data)
                    else -> emit(remoteData)
                }
            }
        }
    }.flowOn(Dispatchers.IO)

//    override suspend fun getSingleMovieData(movieId: String): Flow<ResponseState<MovieEntity>> {
//        val movieData = withContext(Dispatchers.IO) {
//            return@withContext localDataSource.getSingleMovie(movieId)
//        }
//        return flow {
//            emit(ResponseState.Success(movieData[0]))
//        }
//    }

//    private suspend fun insertSingleMovieToDb(data: SingleMoviesEntity) {
//        withContext(Dispatchers.IO) {
//            localDataSource.insertSingleMovie(data)
//        }
//    }
//
//    private suspend fun getSingleFromServer(movieId: String): NetworkResponseState<SingleMoviesEntity> {
//        if (!hasInternetConnection())
//            return NetworkResponseState.Error(null, "Network Error")
//        return withContext(Dispatchers.IO) {
//            val response = remoteDataSource.getSingleMovie(movieId)
//            if (response.body() != null) {
//                return@withContext NetworkResponseState.Success(response.body()?.mapToEntity()!!)
//            } else {
//                return@withContext NetworkResponseState.Error(null, message = "System Error")
//            }
//        }
//    }
//
//    private suspend fun insertToDb(data: List<PopularMovieEntity>?) {
//        withContext(Dispatchers.IO) {
//            localDataSource.insertMovie(data!!)
//        }
//    }

//    private suspend fun getPopularFromServer(): NetworkResponseState<List<PopularMovieEntity>> {
//        return remoteDataSource.getPopularMovies(true)
//        return withContext(Dispatchers.IO) {
//            val response = remoteDataSource.getPopularMovies(true)
//            remoteDataSource.getPopularMovies(true).data?.items?.let { items ->
//                return@withContext NetworkResponseState.Success(items.map { it.mapToEntity() })
//            }
//            if (response.data?.items?.isNotEmpty()) {
//                return@withContext NetworkResponseState.Success(response.body()?.items?.map { it.mapToEntity() }!!)
//            } else {
//                return@withContext NetworkResponseState.Error(null, message = "System Error")
//            }
//        }
//    }


//    private fun hasInternetConnection(): Boolean {
//        val connectivityManager = context
//            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        val activeNetwork = connectivityManager.activeNetwork ?: return false
//        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
//
//        return when {
//            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//            else -> false
//        }
//    }

}