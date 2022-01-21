package com.example.stackoverflowapi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StackOverflowAPI: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
