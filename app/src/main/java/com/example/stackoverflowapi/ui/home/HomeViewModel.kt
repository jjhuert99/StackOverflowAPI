package com.example.stackoverflowapi.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.stackoverflowapi.network.StackOverflowRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val StackOverflowRepo: StackOverflowRepo,
    private val dispatcher: Dispatchers
) : ViewModel() {

}
