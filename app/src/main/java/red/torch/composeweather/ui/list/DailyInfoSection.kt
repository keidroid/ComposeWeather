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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composeweather.data.DailyInfo
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun DailyInfoSection(dailyInfo: DailyInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(40.dp))

//        Card(
//            shape = RoundedCornerShape(50),
//            elevation = 2.dp,
//        ) {
//        }

        TodayWeatherInfo(dailyInfo = dailyInfo)
        TemperatureText(celsius = dailyInfo.celsius)
    }
}

@Preview
@Composable
fun DailyInfoSectionDarkPreview() {
    MyTheme(darkTheme = true) {
        val dailyInfo = DailyInfo(
            id = 1,
            date = "Tue, 23 March",
            celsius = 16,
            celsiusFeelLike = 20
        )
        DailyInfoSection(dailyInfo)
    }
}

@Preview
@Composable
fun DailyInfoSectionLightPreview() {
    MyTheme(darkTheme = false) {
        val dailyInfo = DailyInfo(
            id = 1,
            date = "Tue, 23 March",
            celsius = 16,
            celsiusFeelLike = 20
        )
        DailyInfoSection(dailyInfo)
    }
}


