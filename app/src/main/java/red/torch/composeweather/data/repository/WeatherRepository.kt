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
import red.torch.composeweather.data.DailyInfo
import red.torch.composeweather.data.RepoResult
import kotlin.coroutines.CoroutineContext

interface WeatherRepository {
    suspend fun getList(): RepoResult<WeatherListInfo>
}

data class WeatherListInfo(
    val location: String,
    val country: String,
    val dailyInfo: DailyInfo,
    val weeklyInfo: List<DailyInfo>
)

class FakeWeatherRepository(
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : WeatherRepository {
    override suspend fun getList(): RepoResult<WeatherListInfo> {
        return withContext(coroutineContext) {
            val info = WeatherListInfo(
                location = "Tokyo",
                country = "Japan",
                dailyInfo = DailyInfo(
                    id = 1,
                    date = "Tue, 23 March",
                    dateDescription = "Tuesday, 23, March",
                    celsius = 16,
                    celsiusFeelLike = 20,
                ),
                weeklyInfo = emptyList()
            )
            RepoResult.Success(info)
        }
    }
}
