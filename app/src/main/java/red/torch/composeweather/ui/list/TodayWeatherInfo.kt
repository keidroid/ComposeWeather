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
package red.torch.composeweather.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import red.torch.composeweather.R
import red.torch.composeweather.data.DailyInfo

@Composable
fun TodayWeatherInfo(dailyInfo: DailyInfo) {
    val todayDescription = stringResource(
        id = R.string.today_description,
        dailyInfo.dateDescription,
        dailyInfo.weatherDescription
    )
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .semantics(
                mergeDescendants = true
            ) {
                contentDescription = todayDescription
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_wi_day_rainy),
            contentDescription = null,
            tint = MaterialTheme.colors.secondary,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            modifier = Modifier
                .height(56.dp)
                .width(1.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                stringResource(id = R.string.common_today),
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .paddingFromBaseline(top = 8.dp, bottom = 8.dp)
            )
            Text(
                dailyInfo.dateLabel,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .paddingFromBaseline(top = 8.dp, bottom = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(24.dp))
    }
}
