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
package red.torch.composeweather.ui.list.daily

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import red.torch.composeweather.data.Weather
import red.torch.composeweather.data.WeatherInfo
import red.torch.composeweather.ui.common.Background
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun DailyInfoSection(weatherInfo: WeatherInfo, enabled: Boolean = true) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        DailyWeatherView(weatherInfo = weatherInfo)
        TodayTemperatureView(celsius = weatherInfo.celsius, enabled)
    }
}

@Preview
@Composable
fun DailyInfoSectionDarkPreview() {
    val dailyInfo = WeatherInfo(
        dateLabel = "Tue, March 23",
        weather = Weather.RainyThenSunny,
        celsius = 16,
    )
    MyTheme(darkTheme = true) {
        Background {
            DailyInfoSection(dailyInfo)
        }
    }
}

@Preview
@Composable
fun DailyInfoSectionLightPreview() {
    val dailyInfo = WeatherInfo(
        dateLabel = "Tue, March 23",
        weather = Weather.Sunny,
        celsius = 16,
    )
    MyTheme(darkTheme = false) {
        Background {
            DailyInfoSection(dailyInfo)
        }
    }
}
