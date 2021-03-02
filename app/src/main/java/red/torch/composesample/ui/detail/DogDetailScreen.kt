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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.accompanist.glide.GlideImage
import red.torch.composesample.R
import red.torch.composesample.ui.theme.MyTheme
import red.torch.composesample.viewmodel.DogDetailViewModel

@Composable
fun DogDetailScreen(
    navController: NavController,
    dogId: Int,
    viewModel: DogDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val dogDetailInfoState = viewModel.dogDetailInfo.observeAsState(null)
    viewModel.fetchDogDetail(dogId)

    Scaffold {
        dogDetailInfoState.value?.also { dog ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                item {
                    Box {
                        GlideImage(
                            data = dog.thumbnailUrl,
                            contentDescription = dog.title,
                            fadeIn = false,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.background),
                            contentScale = ContentScale.Crop,
                        )

                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .clip(CircleShape)
                                .background(Color.Black.copy(0.25f))
                                .clickable { navController.popBackStack() }
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_baseline_arrow_back_24),
                                contentDescription = stringResource(R.string.common_back),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }

                item {
                    DogDetailOverviewSection(dog) {
                        viewModel.toggleFavorite()
                    }
                }
                item {
                    DogDetailBasicInfoSection(dog)
                }
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
@Preview
fun DogDetailScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        DogDetailScreen(rememberNavController(), 1)
    }
}
