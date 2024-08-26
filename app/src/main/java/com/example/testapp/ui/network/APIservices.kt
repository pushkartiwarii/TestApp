package com.example.testapp.ui.network

import com.example.testapp.ui.screens.AirQualityData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//interface AirQualityApiService {
//    @GET("air_pollution")
//    suspend fun getAirQuality(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("appid") apiKey: String
//    ): AirQualityData
//}
//object RetrofitInstance {
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://api.openweathermap.org/data/2.5/")  // Replace with the actual base URL
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val api: AirQualityApiService by lazy {
//        retrofit.create(AirQualityApiService::class.java)
//    }
//}
private const val BASE_URL ="https://api.openweathermap.org/data/3.0"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface AirQualityApiService {
    @GET("AirQuality")
    suspend fun getAirQuality(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,

    ):Air
}
object WeatherApi {
    val retrofitService : AirQualityApiService by lazy {
        retrofit.create(AirQualityApiService::class.java)
    }
}