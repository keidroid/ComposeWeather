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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composesample.R
import red.torch.composesample.data.repository.ContributorInfo
import red.torch.composesample.data.repository.DogDetailInfo
import red.torch.composesample.ui.theme.MyTheme

@Composable
fun DogDetailBasicInfoSection(
    dog: DogDetailInfo
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.dog_detail_basic_info_title),
            style = typography.body1,
        )
    }
    Surface(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DogDetailTextColumn(
                stringResource(R.string.dog_detail_basic_info_location),
                dog.location,
            )
            DogDetailTextColumn(
                stringResource(R.string.dog_detail_basic_info_type),
                dog.type,
            )
            DogDetailTextColumn(
                stringResource(R.string.dog_detail_basic_info_age),
                dog.age,
            )
            DogDetailTextColumn(
                stringResource(R.string.dog_detail_basic_info_gender),
                dog.gender,
            )
            DogDetailTextColumn(
                stringResource(R.string.dog_detail_basic_info_size),
                dog.size,
            )
            DogDetailTextColumn(
                stringResource(R.string.dog_detail_basic_info_vaccine),
                dog.vaccine,
            )
        }
    }
}

@Preview("Dark Theme")
@Composable
fun DogDetailBasicInfoSectionDarkPreview() {
    val dog = DogDetailInfo(
        id = 0,
        thumbnailUrl = "",
        title = "",
        createdAt = "",
        limitedAt = "",
        pageView = 0,
        favoriteCount = 0,
        location = "東京都",
        type = "柴犬",
        age = "1歳2ヶ月",
        gender = "♂",
        size = "大型犬",
        vaccine = "接種済み",
        features = "",
        contributor = ContributorInfo(
            0,
            "",
            ""
        ),
        reason = "",
        personality = "",
        recommend = "",
    )
    MyTheme(darkTheme = true) {
        DogDetailBasicInfoSection(dog)
    }
}

@Preview("Light Theme")
@Composable
fun DogDetailBasicInfoSectionLightPreview() {
    val dog = DogDetailInfo(
        id = 0,
        thumbnailUrl = "",
        title = "",
        createdAt = "",
        limitedAt = "",
        pageView = 0,
        favoriteCount = 0,
        location = "東京都",
        type = "柴犬",
        age = "1歳2ヶ月",
        gender = "♂",
        size = "大型犬",
        vaccine = "接種済み",
        features = "",
        contributor = ContributorInfo(
            0,
            "",
            ""
        ),
        reason = "",
        personality = "",
        recommend = "",
    )
    MyTheme(darkTheme = false) {
        DogDetailBasicInfoSection(dog)
    }
}
