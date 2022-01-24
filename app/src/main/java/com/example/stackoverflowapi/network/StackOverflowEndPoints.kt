package com.example.stackoverflowapi.network

import retrofit2.Response
import retrofit2.http.GET

interface StackOverflowEndPoints {
    //url yields post from july 2020 to january 2022, as of now is limited by page limititations
    @GET("2.3/questions?pagesize=100&fromdate=1593561600&todate=1642896000&order=desc&sort=activity&site=stackoverflow&filter=!-KbmneoxUdFEsDppX_v9QlgN.p912M7vz")
    suspend fun getPosts():
            Response<Data>
}
