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
package red.torch.composesample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import red.torch.composesample.data.RepoResult
import red.torch.composesample.data.repository.DogDetailInfo
import red.torch.composesample.data.repository.DogRepository
import javax.inject.Inject

@HiltViewModel
class DogDetailViewModel @Inject constructor(
    private val dogRepository: DogRepository,
) : ViewModel() {

    private val _dogDetailInfo: MutableLiveData<DogDetailInfo> = MutableLiveData()
    val dogDetailInfo: LiveData<DogDetailInfo>
        get() = _dogDetailInfo

    private val _isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    fun fetchDogDetail(dogId: Int) {
        viewModelScope.launch {
            when (val result = dogRepository.getDetail(dogId)) {
                is RepoResult.Success -> {
                    _dogDetailInfo.value = result.data
                }
            }
        }
    }

    fun toggleFavorite() {
        val currentIsFavorite = _isFavorite.value == true
        _isFavorite.value = !currentIsFavorite
    }

    fun inquiry() {
        // TODO :
    }
}
