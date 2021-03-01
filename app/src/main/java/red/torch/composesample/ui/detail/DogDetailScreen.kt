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
package red.torch.composesample.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import red.torch.composesample.data.repository.DogDetailInfo
import red.torch.composesample.ui.common.DogAdaptionTopAppBar

@Composable
fun DogDetailScreen(
    navController: NavController,
    dogId: Int,
    viewModel: DogDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val dogDetailInfo = viewModel.dogDetailInfo.observeAsState(DogDetailInfo())

    Scaffold(
        topBar = { DogAdaptionTopAppBar() }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {

            // Search Bar Mock
            item {
                Spacer(Modifier.height(4.dp))
            }

            item {
                Text("Hello Detail: $dogId")
            }
        }
    }
}
