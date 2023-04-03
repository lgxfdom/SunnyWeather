package com.sunnyweather.android

import android.app.Application
import android.content.Context
import android.util.Log

class SunnyWeatherApplication:Application() {
    companion object{
        lateinit var context:Context
        const val TOKEN = "RZW7QYmcJk9CdyIn"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}