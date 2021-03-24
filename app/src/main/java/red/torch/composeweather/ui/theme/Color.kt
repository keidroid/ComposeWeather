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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Sun200 = Color(0xFFFFAA72)
val Sun500 = Color(0xFFFF6300)

val Cloud200 = Color(0xFFCFCFCF)
val Cloud500 = Color(0xFF9E9E9E)

val Rain200 = Color(0xFF72C8FF)
val Rain500 = Color(0xFF0090F9)

val BackgroundLight100 = Color(0xFFF8F6F4)
val BackgroundLight150 = Color(0xFFF0F5FA)
val BackgroundLight200 = Color(0xFFE4F4FD)
val OnBackgroundLight = Color(0xFF3C3838)

val BackgroundDark800 = Color(0xFF03030E)
val BackgroundDark850 = Color(0xFF05040B)
val BackgroundDark900 = Color(0xFF080604)
val OnBackgroundDark = Color(0xFFFCF8F8)

val DarkColors = darkColors(
    primary = Sun500,
    secondary = Rain500,
    background = BackgroundDark850,
    onBackground = OnBackgroundDark,
    surface = BackgroundDark900,
    onSurface = OnBackgroundDark
)

val LightColors = lightColors(
    primary = Sun200,
    secondary = Rain200,
    background = BackgroundLight150,
    onBackground = OnBackgroundLight,
    surface = BackgroundLight100,
    onSurface = OnBackgroundLight,
)

val VerticalLightGradientBrush = Brush.verticalGradient(
    colors = listOf(
        BackgroundLight200,
        BackgroundLight100
    )
)

val VerticalDarkGradientBrush = Brush.verticalGradient(
    colors = listOf(
        BackgroundDark800,
        BackgroundDark900
    )
)
