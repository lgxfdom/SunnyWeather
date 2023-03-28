package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchPlaces(query:String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResonse = SunnyWeatherNetwork.searchPlaces(query)
            if(placeResonse.status=="ok"){
                val places = placeResonse.places
                Result.success<List<Place>>(places)
            }else{
                Result.failure(java.lang.RuntimeException("response status is ${placeResonse.status}"))
            }
        }catch (e:java.lang.Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }

}

