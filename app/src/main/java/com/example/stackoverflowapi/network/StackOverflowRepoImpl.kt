package com.example.stackoverflowapi.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StackOverflowRepoImpl @Inject constructor(
    private val dispatcher: Dispatchers,
    private val retroObject: StackOverflowEndPoints
    ): StackOverflowRepo{

    override suspend fun getPosts()
    : ServiceResult<Data?> {
        return withContext(dispatcher.IO){
            val dataResponse = retroObject.getPosts()
            if(dataResponse.isSuccessful){
                ServiceResult.Succes(dataResponse.body())
            }else{
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }
}
