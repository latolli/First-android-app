package com.example.app123

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App123App : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}