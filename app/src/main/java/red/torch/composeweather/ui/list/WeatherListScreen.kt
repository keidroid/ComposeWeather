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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import red.torch.composeweather.R
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
            BackgroundDark1,
            BackgroundDark
        )
    )

    Scaffold {
        weatherListInfo.value?.also { weatherListInfo ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = if (colors.isLight) {
                            verticalLightGradientBrush
                        } else {
                            verticalDarkGradientBrush
                        }
                    )
            ) {
                item {
                    Text(
                        stringResource(id = R.string.app_name),
                        style = typography.subtitle1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .paddingFromBaseline(top = 80.dp)
                    )
                }

                item {
                    DailyInfoSection(weatherListInfo.dailyInfo)
                }

                items(weatherListInfo.weeklyInfo) {
//                    group.dogSimpleInfos.forEach { dogSimpleInfo ->
//                        item {
//                            DogListContentsItem(dogSimpleInfo) {
//                            }
//                        }
//                    }
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
