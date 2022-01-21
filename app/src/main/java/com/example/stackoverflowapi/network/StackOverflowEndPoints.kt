package com.example.stackoverflowapi.network

import retrofit2.Response
import retrofit2.http.GET

interface StackOverflowEndPoints {
    @GET("2.3/questions?fromdate=1640995200&todate=1642723200&order=desc&sort=activity&site=stackoverflow&filter=!216ygkw8.vGSXRH64k6U8")
    suspend fun getPosts():
            Response<Data>
}
