package com.example.stackoverflowapi.network

interface StackOverflowRepo {
    suspend fun getPosts(): ServiceResult<Data?>
}
