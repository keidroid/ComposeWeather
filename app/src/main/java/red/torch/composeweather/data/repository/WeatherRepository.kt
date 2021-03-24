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
package red.torch.composeweather.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import red.torch.composeweather.data.RepoResult
import red.torch.composeweather.data.Weather
import red.torch.composeweather.data.WeatherInfo
import red.torch.composeweather.data.WeatherListInfo
import kotlin.coroutines.CoroutineContext

interface WeatherRepository {
    suspend fun getList(): RepoResult<WeatherListInfo>
}

class FakeWeatherRepository(
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : WeatherRepository {
    override suspend fun getList(): RepoResult<WeatherListInfo> {
        return withContext(coroutineContext) {
            val info = WeatherListInfo(
                location = "Tokyo",
                country = "Japan",
                dailyInfo = WeatherInfo(
                    dateLabel = "Tue, March 23",
                    dateDescription = "Tuesday, March 23",
                    weather = Weather.find("rainy_then_sunny"),
                    celsius = 16,
                ),
                hourlyInfo = listOf(
                    WeatherInfo(
                        dateLabel = "12AM",
                        dateDescription = "12AM",
                        weather = Weather.Sunny,
                        celsius = 18,
                    ),
                    WeatherInfo(
                        dateLabel = "2PM",
                        dateDescription = "2PM",
                        weather = Weather.SunnyThenCloudy,
                        celsius = 20,
                    ),
                    WeatherInfo(
                        dateLabel = "4PM",
                        dateDescription = "4PM",
                        weather = Weather.SunnyThenRainy,
                        celsius = 16,
                        focus = true,
                    ),
                    WeatherInfo(
                        dateLabel = "6PM",
                        dateDescription = "Tuesday, March 23",
                        weather = Weather.Rainy,
                        celsius = 9,
                    ),
                    WeatherInfo(
                        dateLabel = "8PM",
                        dateDescription = "8PM",
                        weather = Weather.SunnyThenRainy,
                        celsius = 7,
                    ),
                    WeatherInfo(
                        dateLabel = "10PM",
                        dateDescription = "10PM",
                        weather = Weather.RainyThenSunny,
                        celsius = 9,
                    ),
                    WeatherInfo(
                        dateLabel = "12PM",
                        dateDescription = "12PM",
                        weather = Weather.Sunny,
                        celsius = 8,
                    )
                )
            )
            RepoResult.Success(info)
        }
    }
}
