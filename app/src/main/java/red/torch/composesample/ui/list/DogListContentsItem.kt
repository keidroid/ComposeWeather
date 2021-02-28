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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.glide.GlideImage
import red.torch.composesample.R
import red.torch.composesample.data.repository.DogSimpleInfo

@Composable
fun DogListContentsItem(
    dog: DogSimpleInfo,
    onClick: (Int) -> Unit
) {
    Box(modifier = Modifier.padding(4.dp)) {
        Card(
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .clickable(
                    enabled = true,
                    onClick = {
                        onClick(dog.id)
                    }
                )
                .fillMaxWidth()
        ) {
            Row {
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    GlideImage(
                        data = dog.thumbnailUrl,
                        contentDescription = dog.title,
                        fadeIn = true,
                        modifier = Modifier
                            .size(120.dp)
                            .background(colors.background),
                        contentScale = ContentScale.Crop,
                        loading = {
                            Box(contentAlignment = Alignment.Center) {
                                CircularProgressIndicator(Modifier.align(Alignment.Center))
                            }
                        },
                        error = {
                            Box(contentAlignment = Alignment.Center) {
                                Image(
                                    painterResource(R.drawable.ic_baseline_no_photography_24),
                                    contentDescription = dog.title,
                                    modifier = Modifier.size(48.dp)
                                )
                            }
                        }
                    )

                    // local data
                    /*
                    Image(
                        painterResource(R.drawable.header),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp),
                        contentScale = ContentScale.Crop
                    )
                    */
                }

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {

                    Text(
                        dog.title,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Spacer(
                        Modifier
                            .height(4.dp)
                            .weight(1f)
                    )

                    if (dog.features.isNotBlank()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(colors.onSurface.copy(0.25f))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_baseline_pets_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(4.dp),
                                )
                            }

                            Text(
                                dog.features,
                                color = colors.onSurface.copy(0.5f),
                                style = MaterialTheme.typography.body2,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }

                    if (dog.location.isNotBlank()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(colors.onSurface.copy(0.25f))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(4.dp),
                                )
                            }

                            Text(
                                dog.location,
                                color = colors.onSurface.copy(0.5f),
                                style = MaterialTheme.typography.body2,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// @Composable
// @Preview(widthDp = 360, heightDp = 132)
// fun DogListContentsItemDarkPreview() {
//    MyTheme(darkTheme = true) {
//        DogListContentsItem("yeah") {
//        }
//    }
// }
//
// @Composable
// @Preview(widthDp = 360, heightDp = 132)
// fun DogListContentsItemLightPreview() {
//    MyTheme(darkTheme = false) {
//        DogListContentsItem("yeah") {
//        }
//    }
// }
