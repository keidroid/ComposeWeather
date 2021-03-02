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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import red.torch.composesample.R
import red.torch.composesample.data.repository.DogDetailInfo

@Composable
fun DogDetailOverviewSection(
    dog: DogDetailInfo,
    onClickFavorite: () -> Unit,
) {
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {

                Text(
                    text = stringResource(R.string.dog_detail_overview_limit_date, dog.limitedAt),
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                // val isFavorite = viewModel.isFavorite.observeAsState(false)

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(CircleShape)
                        .clickable { onClickFavorite() }
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_favorite_border_24),
                        contentDescription = stringResource(R.string.common_favorite),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Text(
                text = dog.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(percent = 50))
                        .background(MaterialTheme.colors.primary)
                        .weight(2f)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                            .clip(RoundedCornerShape(percent = 50))
                            .background(MaterialTheme.colors.onPrimary.copy(0.95f))
                    ) {
                        Text(
                            text = stringResource(R.string.dog_detail_overview_within),
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                Divider(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(1.dp)
                        .height(48.dp)
                )

                // val isFavorite = viewModel.isFavorite.observeAsState(false)

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_search_24_primary),
                        contentDescription = stringResource(R.string.common_favorite),
                        modifier = Modifier
                            .padding(8.dp)
                            .alpha(0.5f)
                            .size(20.dp)
                    )

                    Text(
                        text = dog.pageView.toString(),
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onSurface.copy(0.5f)
                    )
                }

                Divider(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(1.dp)
                        .height(48.dp)
                )

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_favorite_24_primary),
                        contentDescription = stringResource(R.string.common_favorite),
                        modifier = Modifier
                            .padding(8.dp)
                            .alpha(0.5f)
                            .size(20.dp),
                    )

                    Text(
                        text = dog.favoriteCount.toString(),
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onSurface.copy(0.5f),
                    )
                }

                Divider(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(1.dp)
                        .height(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
