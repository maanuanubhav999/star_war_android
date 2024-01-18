package com.asraven.start_wars.data.di

import android.content.Context
import com.asraven.start_wars.data.Api
import com.asraven.start_wars.data.Hosts
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    @Singleton
    @Named("Api")
    fun providesGithubApiRetrofit(
        loggingInterceptor: HttpLoggingInterceptor,

        @ApplicationContext context: Context,
    ): Retrofit = buildRetrofit(
        Hosts.STARWAR,
        context,
        loggingInterceptor

    )


    private fun buildRetrofit(
        baseUrl: String,
        @ApplicationContext context: Context,
        loggingInterceptor: HttpLoggingInterceptor,
    ): Retrofit {

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .followRedirects(false)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providesGithubApiService(
        @Named("Api") retrofit: Retrofit,
    ): Api {
        return retrofit.create(Api::class.java)
    }
}