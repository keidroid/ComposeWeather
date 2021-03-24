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

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import red.torch.composeweather.MyCoroutineRule
import red.torch.composeweather.data.RepoResult
import red.torch.composeweather.data.WeatherInfo

class WeatherRepositoryTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MyCoroutineRule()

    @Test
    fun getListTest() = runBlocking {
        val repository = FakeWeatherRepository(coroutineContext = Dispatchers.Main)
        val result = repository.getList()

        assertThat(result is RepoResult.Success).isTrue()
        result as RepoResult.Success
        assertThat(result.data.location).isEqualTo("Tokyo")
        assertThat(result.data.country).isEqualTo("Japan")
        assertThat(result.data.dailyInfo).isInstanceOf(WeatherInfo::class.java)
        // 2時間おきに1日分
        assertThat(result.data.hourlyInfo.size).isEqualTo(7)
        assertThat(result.data.hourlyInfo[0]).isInstanceOf(WeatherInfo::class.java)
    }
}
