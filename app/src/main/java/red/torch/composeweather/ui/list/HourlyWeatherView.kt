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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composeweather.data.Weather
import red.torch.composeweather.data.WeatherInfo
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun HourlyWeatherView(weeklyInfo: List<WeatherInfo>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(0.dp)
    ) {
        weeklyInfo.forEach {
            item {
                HourlyListItemView(it)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun HourlyWeatherViewDarkPreview() {
    MyTheme(darkTheme = true) {
        val dailyInfo = WeatherInfo(
            dateLabel = "4PM",
            weather = Weather.RainyThenSunny,
            celsius = 16,
        )
        val weeklyInfo = mutableListOf<WeatherInfo>().apply {
            repeat(7) {
                add(dailyInfo)
            }
        }.toList()
        HourlyWeatherView(weeklyInfo)
    }
}

@Preview
@Composable
fun WeeklyWeatherViewLightPreview() {
    MyTheme(darkTheme = false) {
        val dailyInfo = WeatherInfo(
            dateLabel = "4PM",
            weather = Weather.SunnyThenCloudy,
            celsius = 16,
        )
        val weeklyInfo = mutableListOf<WeatherInfo>().apply {
            repeat(7) {
                add(dailyInfo)
            }
        }.toList()
        HourlyWeatherView(weeklyInfo)
    }
}
