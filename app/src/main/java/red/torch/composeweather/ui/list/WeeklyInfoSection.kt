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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import red.torch.composeweather.data.DailyInfo
import red.torch.composeweather.data.Weather
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun WeeklyInfoSection(dailyInfo: DailyInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        TodayWeatherView(dailyInfo = dailyInfo)
        TemperatureView(celsius = dailyInfo.celsius)
    }
}

@Preview
@Composable
fun WeeklyInfoSectionDarkPreview() {
    MyTheme(darkTheme = true) {
        val dailyInfo = DailyInfo(
            dateLabel = "Tue, 23 March",
            weather = Weather.RainyThenSunny,
            celsius = 16,
            celsiusFeelLike = 20
        )
        WeeklyInfoSection(dailyInfo)
    }
}

@Preview
@Composable
fun WeeklyInfoSectionLightPreview() {
    MyTheme(darkTheme = false) {
        val dailyInfo = DailyInfo(
            dateLabel = "Tue, 23 March",
            weather = Weather.Sunny,
            celsius = 16,
            celsiusFeelLike = 20
        )
        WeeklyInfoSection(dailyInfo)
    }
}
