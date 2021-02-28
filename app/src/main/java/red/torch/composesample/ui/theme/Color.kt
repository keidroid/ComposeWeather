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
package red.torch.composesample.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val teal200 = Color(0xFF03DAC5)
val teal500 = Color(0xFF009688)
val teal700 = Color(0xFF018786)

val Primary = teal500
val PrimaryLight = teal700
val PrimaryDark = teal200

val OnBackgroundDark = Color(0xFFFCF8F8)
val OnBackgroundLight = Color(0xFF3C3838)

val SmokeDark = Color(0x08000000)
val SmokeLight = Color(0x08FFFFFF)

val DarkColors = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryLight,
    secondary = teal700,
    background = SmokeLight,
    onBackground = OnBackgroundDark,
)

val LightColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryLight,
    secondary = teal700,
    background = SmokeDark,
    onBackground = OnBackgroundLight,
)
