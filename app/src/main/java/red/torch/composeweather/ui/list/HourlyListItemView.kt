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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composeweather.R
import red.torch.composeweather.data.Weather
import red.torch.composeweather.data.WeatherInfo
import red.torch.composeweather.data.color
import red.torch.composeweather.ui.theme.ElevationCard
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun HourlyListItemView(weatherInfo: WeatherInfo) {
    val description = stringResource(
        R.string.hourly_description,
        weatherInfo.dateDescription,
        stringResource(weatherInfo.weather.description),
        weatherInfo.celsius
    )
    Card(
        shape = shapes.small,
        elevation = ElevationCard,
        modifier = Modifier.semantics(
            mergeDescendants = true
        ) {
            contentDescription = description
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.size(64.dp, 144.dp)
        ) {

            Spacer(modifier = Modifier.weight(4f))

            Text(
                text = weatherInfo.dateLabel,
                style = typography.body2,
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shapes.small)
                    .background(colors.background)
                    .size(56.dp)
            ) {
                Icon(
                    painter = painterResource(id = weatherInfo.weather.icon),
                    contentDescription = null,
                    tint = weatherInfo.weather.color(colors.isLight),
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            val temperature = stringResource(id = R.string.temperature_label, weatherInfo.celsius)
            Text(
                text = " $temperature",
                style = typography.body1,
            )

            Spacer(modifier = Modifier.weight(4f))
        }
    }
}

@Preview
@Composable
fun HourlyListItemViewDarkPreview() {
    MyTheme(darkTheme = true) {
        val dailyInfo = WeatherInfo(
            dateLabel = "4PM",
            weather = Weather.RainyThenSunny,
            celsius = 16,
        )
        HourlyListItemView(dailyInfo)
    }
}

@Preview
@Composable
fun HourlyListItemViewLightPreview() {
    MyTheme(darkTheme = false) {
        val dailyInfo = WeatherInfo(
            dateLabel = "4PM",
            weather = Weather.Sunny,
            celsius = 16,
        )
        HourlyListItemView(dailyInfo)
    }
}
