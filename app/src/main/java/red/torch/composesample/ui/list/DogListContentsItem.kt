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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composesample.R
import red.torch.composesample.data.repository.DogSimpleInfo
import red.torch.composesample.ui.theme.MyTheme

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
                    DogListThumbnailImage(dog.thumbnailUrl)
                }

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {

                    Text(
                        dog.title,
                        style = MaterialTheme.typography.subtitle1,
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
                        DogListIconAndText(
                            drawableResId = R.drawable.ic_baseline_pets_24,
                            text = dog.features
                        )
                    }

                    if (dog.location.isNotBlank()) {
                        DogListIconAndText(
                            drawableResId = R.drawable.ic_baseline_location_on_24,
                            text = dog.location
                        )
                    }
                }
            }
        }
    }
}

@Preview("Dark Theme")
@Composable
fun DogListContentsItemDarkPreview() {
    val dog = DogSimpleInfo(
        id = 123,
        thumbnailUrl = "",
        title = "title",
        location = "location",
        features = "features",
    )
    MyTheme(darkTheme = true) {
        DogListContentsItem(dog) {
        }
    }
}

@Preview("Light Theme")
@Composable
fun DogListContentsItemLightPreview() {
    val dog = DogSimpleInfo(
        id = 123,
        thumbnailUrl = "https://torch.red/compose_mock/contributor_01.jpg",
        title = "title",
        location = "location",
        features = "features",
    )
    MyTheme(darkTheme = false) {
        DogListContentsItem(dog) {
        }
    }
}
