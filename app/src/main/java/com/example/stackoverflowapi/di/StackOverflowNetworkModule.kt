package com.example.stackoverflowapi.di

import com.example.stackoverflowapi.network.RetrofitFactory
import com.example.stackoverflowapi.network.StackOverflowEndPoints
import com.example.stackoverflowapi.network.StackOverflowRepo
import com.example.stackoverflowapi.network.StackOverflowRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object StackOverflowNetworkModule {
    private const val BASE_URL = "https://api.stackexchange.com/"

    @Singleton
    @Provides
    fun provideStackOverflowEndPoints(): StackOverflowEndPoints{
        return RetrofitFactory.retrofitProvider(
            StackOverflowEndPoints::class.java,
            BASE_URL
        )
    }

    @Singleton
    @Provides
    fun provideStackOverflowRepo(dispatcher: Dispatchers, retroObject: StackOverflowEndPoints): StackOverflowRepo{
        return StackOverflowRepoImpl(dispatcher, retroObject)
    }
}
