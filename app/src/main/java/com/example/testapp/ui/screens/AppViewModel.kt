package com.example.testapp.ui.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.ui.network.Air
import com.example.testapp.ui.network.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Status{
    LOADING,
    SUCCESS,
    ERROR
}

data class AirQualityData(
    val city: String,
    val aqi: Int,
    val pm10: Double,
    val pm2_5: Double,

    )
data class WeatherState(
    val result: Air = Air(),
    val status: Status=Status.LOADING,
    val error: String= ""

)


class AirQualityViewModel : ViewModel() {
    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()
    init {
        getAirQualityData()
    }

    private fun getAirQualityData() {
        viewModelScope.launch {
            try {
                val result = WeatherApi.retrofitService.getAirQuality(
                    lat = 52.52,
                    lon = 13.41,
                    apiKey = "ef37596dcb40fa76ada6e4b82b29c5b1"
                )
                _state.update { it.copy(result=result, status = Status.SUCCESS) }
            }
            catch (e:Exception) {
                _state.update {
                    it.copy(status = Status.ERROR, error = e.message?:"Something went wrong")
                }
            }
        }
    }
}