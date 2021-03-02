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
package red.torch.composesample.ui.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import red.torch.composesample.ui.common.DogAdaptionTopAppBar
import red.torch.composesample.viewmodel.DogListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DogListScreen(
    navController: NavController,
    viewModel: DogListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val dogListInfoState = viewModel.dogListInfo.observeAsState(null)
    viewModel.fetchDogList()

    Scaffold(
        topBar = { DogAdaptionTopAppBar() }
    ) {
        dogListInfoState.value?.also { dogListInfo ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {

                item {
                    Spacer(Modifier.height(4.dp))
                    DogListHeaderSection(dogListInfo.target, dogListInfo.totalCount)
                }

                dogListInfo.groups.forEach { group ->
                    // Experimental
                    stickyHeader {
                        DogListDateHeader(group.label)
                    }
                    group.dogSimpleInfos.forEach { dogSimpleInfo ->
                        item {
                            DogListContentsItem(dogSimpleInfo) { dogId ->
                                navController.navigate("detail/$dogId")
                            }
                        }
                    }
                }
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }
    }
}
