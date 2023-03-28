package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceCreator {
    private const val Base_Url = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass:Class<T>):T = retrofit.create(serviceClass)

    inline fun<reified T> create():T = create(T::class.java)
}