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

val Sun200 = Color(0xFFFFAA72)
val Sun500 = Color(0xFFFF6300)
val Sun700 = Color(0xFFD65500)

val Cloud200 = Color(0xFFCFCFCF)
val Cloud500 = Color(0xFF9E9E9E)
val Cloud700 = Color(0xFF707070)

val Rain200 = Color(0xFF72C8FF)
val Rain500 = Color(0xFF0090F9)
val Rain700 = Color(0xFF0071D9)

val PrimaryLight = Sun200
val Primary = Sun500
val PrimaryDark = Sun700

val SecondaryLight = Rain200
val Secondary = Rain500
val SecondaryDark = Rain700

val BackgroundLight1 = Color(0xFFF8F6F4)
val BackgroundLight = Color(0xFFE4F4FD)
val OnBackgroundLight = Color(0xFF3C3838)

val BackgroundDark1 = Color(0xFF080604)
val BackgroundDark = Color(0x1A237E) // Indigo900
val OnBackgroundDark = Color(0xFFFCF8F8)

val DarkColors = darkColors(
    primary = Primary,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = BackgroundDark1,
)

val LightColors = lightColors(
    primary = Primary,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = BackgroundLight1,
)
