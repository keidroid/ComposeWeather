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
package red.torch.composeweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import red.torch.composeweather.data.RepoResult
import red.torch.composeweather.data.repository.WeatherListInfo
import red.torch.composeweather.data.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class WeatherListViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _weatherListInfo: MutableLiveData<WeatherListInfo> = MutableLiveData()
    val weatherListInfo: LiveData<WeatherListInfo>
        get() = _weatherListInfo

    fun fetchWeatherList() {
        viewModelScope.launch {
            when (val result = weatherRepository.getList()) {
                is RepoResult.Success -> {
                    _weatherListInfo.value = result.data
                }
            }
        }
    }
}
