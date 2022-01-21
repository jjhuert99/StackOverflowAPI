package com.example.stackoverflowapi.network

import retrofit2.Response
import retrofit2.http.GET

interface StackOverflowEndPoints {
    @GET()
    suspend fun getPosts():
            Response<Data>
}
