package com.bensdevelops.techtask.network.service

import com.bensdevelops.techtask.network.ResultCallAdapterFactory
import com.bensdevelops.techtask.network.repository.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Only want one instance of this
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    // All requests will append this base url
    private const val BASE_URL =
        "https://raw.githubusercontent.com/rightmove/Code-Challenge-Android/master/"

    // Provide the client that makes the call and logs the call in the logcat
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logger).build()
    }

    // adds the call converter so that the json becomes usable
    // adds the call adapter so the response is wrapped in a Result class
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(Api::class.java)
    }

}