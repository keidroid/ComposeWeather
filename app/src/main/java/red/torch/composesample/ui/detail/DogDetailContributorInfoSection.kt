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
import androidx.compose.ui.unit.dp
import red.torch.composesample.R
import red.torch.composesample.data.repository.DogDetailInfo

@Composable
fun DogDetailContributorInfoSection(
    dog: DogDetailInfo
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.dog_detail_contributor_info_title),
            style = typography.body1,
        )
    }
    Surface(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DogDetailContributorColumn(
                dog.contributor
            )

            DogDetailTextAreaColumn(
                stringResource(R.string.dog_detail_basic_info_reason),
                dog.reason,
            )
            DogDetailTextAreaColumn(
                stringResource(R.string.dog_detail_basic_info_personality),
                dog.personality,
            )
            DogDetailTextAreaColumn(
                stringResource(R.string.dog_detail_basic_info_recommend),
                dog.recommend,
            )
        }
    }
}
