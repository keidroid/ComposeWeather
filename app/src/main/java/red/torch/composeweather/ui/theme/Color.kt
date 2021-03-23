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

val sun200 = Color(0xFFFFAA72)
val sun300 = Color(0xFFF98C37)
val sun400 = Color(0xFFF37600)
val sun500 = Color(0xFFFF6300)
val sun600 = Color(0xFFE35D00)
val sun700 = Color(0xFFD65500)

val rain200 = Color(0xFF72C8FF)
val rain300 = Color(0xFF16B1FD)
val rain400 = Color(0xFF00A0FC)
val rain500 = Color(0xFF0090F9)
val rain600 = Color(0xFF0083EB)
val rain700 = Color(0xFF0071D9)

val PrimaryLight = sun200
val Primary = sun500
val PrimaryDark = sun700

val SecondaryLight = rain200
val Secondary = rain500
val SecondaryDark = rain700

val BackgroundLight1 = Color(0xFFF8F6F4)
val BackgroundLight = Color(0xFFE4F4FD)
val OnBackgroundLight = Color(0xFF3C3838)

val BackgroundDark1 = Color(0xFF080604)
val BackgroundDark = Color(0xFF1C0C04)
val OnBackgroundDark = Color(0xFFFCF8F8)

val DarkColors = darkColors(
    primary = Primary,
    primaryVariant = PrimaryDark,
    secondary = rain200,
    secondaryVariant = SecondaryDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
)

val LightColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryLight,
    secondary = rain400,
    secondaryVariant = SecondaryLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = BackgroundLight1,
)
