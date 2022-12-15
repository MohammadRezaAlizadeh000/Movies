package com.mra.movies.di

import com.mra.movies.data.network.MoviesAPIService
import com.mra.movies.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonFactory() = GsonConverterFactory.create()


    @Singleton
    @Provides
    fun provideOkHttpclient() = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(convertorFactory: GsonConverterFactory, okHttpClient: OkHttpClient) =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(convertorFactory)
            .build()

    @Singleton
    @Provides
    fun provideMovieAPIService(retrofit: Retrofit) = retrofit.create(MoviesAPIService::class.java)

}