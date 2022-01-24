package com.example.stackoverflowapi.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stackoverflowapi.network.Items
import com.example.stackoverflowapi.network.ServiceResult
import com.example.stackoverflowapi.network.StackOverflowRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val StackOverflowRepo: StackOverflowRepo,
    private val dispatcher: Dispatchers
) : ViewModel() {
    enum class CallStatus {ERROR, DONE}

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    private val _status = MutableLiveData<CallStatus>()
    val status: LiveData<CallStatus> = _status

    private val _post = MutableLiveData<List<Items>>()
    val post: LiveData<List<Items>> = _post

    init{
        getStackOverFlowPosts()
    }

    private fun getStackOverFlowPosts(){
        viewModelScope.launch(dispatcher.IO){
            when(val response = StackOverflowRepo.getPosts()){
                is ServiceResult.Succes ->{
                    //list containing all posts
                    val preFilter = response.data?.items
                    //list after filtering out posts with no accepted answer and less than x answers
                    val filteredList = mutableListOf<Items>()

                    if (preFilter != null){
                        for(i in preFilter){
                            if(i.answer_count > 1 && i.accepted_answer_id != null){
                                filteredList.add(i)
                            }
                        }
                    }
                    _post.postValue(filteredList)
                    _status.postValue(CallStatus.DONE)
                }
                is ServiceResult.Error ->{
                    _status.postValue(CallStatus.ERROR)
                }
                else ->{
                    _status.postValue(CallStatus.ERROR)
                }
            }
        }
    }
}
