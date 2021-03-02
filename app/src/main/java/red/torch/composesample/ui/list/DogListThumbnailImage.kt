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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.glide.GlideImage
import red.torch.composesample.R
import red.torch.composesample.ui.theme.MyTheme

@Composable
fun DogListThumbnailImage(
    url: String,
    thumbnailSize: Dp = 120.dp,
    errorIconSize: Dp = 48.dp
) {
    GlideImage(
        data = url,
        contentDescription = null,
        fadeIn = true,
        modifier = Modifier
            .size(thumbnailSize)
            .background(MaterialTheme.colors.background),
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
                    contentDescription = null,
                    modifier = Modifier.size(errorIconSize)
                )
            }
        }
    )
}

@Composable
@Preview
fun DogListThumbnailImageDarkPreview() {
    MyTheme(darkTheme = true) {
        DogListThumbnailImage("")
    }
}

@Composable
@Preview
fun DogListThumbnailImageLightPreview() {
    MyTheme(darkTheme = false) {
        DogListThumbnailImage("")
    }
}

