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
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composesample.ui.theme.MyTheme

@Composable
fun DogDetailTextAreaColumn(
    label: String,
    text: String,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = typography.body1,
            modifier = Modifier.alpha(0.75f),
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = text,
            style = typography.body2,
        )
    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    )
    Spacer(Modifier.height(16.dp))
}

@Composable
@Preview
fun DogDetailTextAreaColumnDarkPreview() {
    MyTheme(darkTheme = true) {
        DogDetailTextAreaColumn("ラベル", "本文本文本文本文本文本文本文本文本文本文")
    }
}

@Composable
@Preview
fun DogDetailTextAreaColumnLightPreview() {
    MyTheme(darkTheme = false) {
        DogDetailTextAreaColumn("ラベル", "本文本文本文本文本文本文本文本文本文本文")
    }
}
