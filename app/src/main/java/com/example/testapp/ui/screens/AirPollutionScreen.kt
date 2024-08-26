package com.example.testapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AirQualityApp(
    modifier: Modifier = Modifier,
    state: WeatherState,
    onRefresh: () -> Unit,
) {



    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    )  {

        Row {
            Text(text = "Air Pollution ", fontSize = 30.sp,
                fontFamily = FontFamily.Monospace)
        }

        Text(text ="${state.result.coord}")
        Text(text ="${state.result.list}")}
}


