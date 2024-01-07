package com.kendis.myapplication.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kendis.myapplication.data.DefaultMarsPhotoRepository
import com.kendis.myapplication.data.MarsPhotoRepository
import com.kendis.myapplication.network.MarsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): MarsApiService =
        retrofit.create(MarsApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository(apiService: MarsApiService): MarsPhotoRepository {
        return DefaultMarsPhotoRepository(apiService)
    }
}
