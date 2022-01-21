package com.example.stackoverflowapi.di

import com.example.stackoverflowapi.network.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideCoroutines() = Dispatchers

    @Singleton
    @Provides
    fun provideRetrofitFactory() = RetrofitFactory
}
