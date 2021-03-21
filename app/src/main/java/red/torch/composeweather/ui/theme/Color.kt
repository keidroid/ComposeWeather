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
package red.torch.composeweather.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val teal200 = Color(0xFF03DAC5)
val teal500 = Color(0xFF009688)
val teal700 = Color(0xFF018786)

val red200 = Color(0xFFEF9A9A)
val red500 = Color(0xFFF44336)
val red700 = Color(0xFFD32F2F)

val PrimaryLight = teal200
val Primary = teal500
val PrimaryDark = teal700

val SecondaryLight = red200
val Secondary = red500
val SecondaryDark = red700

// #

// val BackgroundLight = Color(0xFFF8F6F4)
val BackgroundLight = Color(0xFFE4F4FD)
val OnBackgroundLight = Color(0xFF3C3838)

val BackgroundDark = Color(0xFF080604)
val OnBackgroundDark = Color(0xFFFCF8F8)

val DarkColors = darkColors(
    primary = Primary,
    primaryVariant = PrimaryDark,
    secondary = SecondaryDark,
    secondaryVariant = SecondaryDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
)

val LightColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryLight,
    secondary = Secondary,
    secondaryVariant = SecondaryLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
)
