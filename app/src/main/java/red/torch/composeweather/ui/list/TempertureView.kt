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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composeweather.R
import red.torch.composeweather.ui.theme.MyTheme

@Composable
fun TemperatureView(celsius: Int) {
    val description = stringResource(R.string.temperature_description, celsius)
    val label = stringResource(id = R.string.temperature_label, celsius)
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .semantics(
                mergeDescendants = true
            ) {
                contentDescription = description
            }
    ) {
        Text(
            label,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(top = 8.dp, bottom = 8.dp)
                .padding(start = 24.dp)
        )
    }
}

@Preview
@Composable
fun TemperatureViewDarkPreview() {
    MyTheme(darkTheme = true) {
        TemperatureView(8)
    }
}

@Preview
@Composable
fun TemperatureViewLightPreview() {
    MyTheme(darkTheme = false) {
        TemperatureView(12)
    }
}
