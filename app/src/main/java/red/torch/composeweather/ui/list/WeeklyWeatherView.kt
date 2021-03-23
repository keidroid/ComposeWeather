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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composeweather.R
import red.torch.composeweather.data.DailyInfo
import red.torch.composeweather.data.Weather
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun WeeklyWeatherView(weeklyInfo: List<DailyInfo>) {
    LazyRow(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(7) {
            Icon(
                painter = painterResource(id = R.drawable.ic_wi_day_rainy),
                contentDescription = null,
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview
@Composable
fun WeeklyWeatherViewDarkPreview() {
    MyTheme(darkTheme = true) {
        val dailyInfo = DailyInfo(
            dateLabel = "Wed, March 23",
            weather = Weather.RainyThenSunny,
            celsius = 16,
            celsiusFeelLike = 20,
        )
        val weeklyInfo = mutableListOf<DailyInfo>().apply {
            repeat(7) {
                add(dailyInfo)
            }
        }.toList()
        WeeklyWeatherView(weeklyInfo)
    }
}

@Preview
@Composable
fun WeeklyWeatherViewLightPreview() {
    MyTheme(darkTheme = false) {
        val dailyInfo = DailyInfo(
            dateLabel = "Wed, March 23",
            weather = Weather.SunnyThenCloudy,
            celsius = 16,
            celsiusFeelLike = 20,
        )
        val weeklyInfo = mutableListOf<DailyInfo>().apply {
            repeat(7) {
                add(dailyInfo)
            }
        }.toList()
        WeeklyWeatherView(weeklyInfo)
    }
}
