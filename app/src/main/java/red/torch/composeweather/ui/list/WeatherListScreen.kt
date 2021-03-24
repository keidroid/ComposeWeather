/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package red.torch.composeweather.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import red.torch.composeweather.data.WeatherListInfo
import red.torch.composeweather.ui.theme.BackgroundDark
import red.torch.composeweather.ui.theme.BackgroundDark1
import red.torch.composeweather.ui.theme.BackgroundLight
import red.torch.composeweather.ui.theme.BackgroundLight1
import red.torch.composeweather.viewmodel.WeatherListViewModel

@Composable
fun WeatherListScreen(
    viewModel: WeatherListViewModel
) {
    val weatherListInfo = viewModel.weatherListInfo.observeAsState(null)
    viewModel.fetchWeatherList()

    val verticalLightGradientBrush = Brush.verticalGradient(
        colors = listOf(
            BackgroundLight,
            BackgroundLight1
        )
    )

    val verticalDarkGradientBrush = Brush.verticalGradient(
        colors = listOf(
            BackgroundDark,
            BackgroundDark1
        )
    )

    Scaffold(
        modifier = Modifier.background(
            brush = if (colors.isLight) {
                verticalLightGradientBrush
            } else {
                verticalDarkGradientBrush
            }
        )
    ) {
        weatherListInfo.value?.also { weatherListInfo ->
            val configuration = LocalConfiguration.current
            when (configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    LandscapeWeatherListScreen(weatherListInfo)
                }
                else -> {
                    PortraitWeatherListScreen(weatherListInfo)
                }
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = colors.onBackground
                )
            }
        }
    }
}

@Composable
fun PortraitWeatherListScreen(weatherListInfo: WeatherListInfo) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        item {
            TitleTextView()
            Spacer(modifier = Modifier.height(40.dp))
        }

        item {
            DailyInfoSection(weatherListInfo.weatherInfo)
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            HourlyInfoSection(weatherListInfo.weeklyInfo)
        }
    }
}

@Composable
fun LandscapeWeatherListScreen(weatherListInfo: WeatherListInfo) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(280.dp)
            ) {
                TitleTextView()
                DailyInfoSection(weatherListInfo.weatherInfo)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                HourlyInfoSection(weatherListInfo.weeklyInfo)
            }
        }
    }
}
