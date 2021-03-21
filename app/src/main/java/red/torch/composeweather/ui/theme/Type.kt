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

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import red.torch.composeweather.R

private val fonts = FontFamily(
    Font(R.font.spartan_regular),
    Font(R.font.spartan_bold, FontWeight.Bold),
    Font(R.font.spartan_semibold, FontWeight.SemiBold),
    Font(R.font.spartan_medium, FontWeight.Medium),
    Font(R.font.spartan_light, FontWeight.Light),
)

val defaultTypography = typographyFromDefaults(
    // TopBar
    h1 = TextStyle(
        fontFamily = fonts,
        fontSize = 96.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.sp,
    ),
    h2 = TextStyle(
        fontFamily = fonts,
        fontSize = 48.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.sp,
    ),
    h3 = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.sp,
    ),
    h4 = null, // Unused
    h5 = null, // Unused
    h6 = null, // Unused
    subtitle1 = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.sp,
    ),
    subtitle2 = null, // Unused
    body1 = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = null, // Unused
    caption = null, // Unused
    overline = null // Unused
)

fun typographyFromDefaults(
    h1: TextStyle?,
    h2: TextStyle?,
    h3: TextStyle?,
    h4: TextStyle?,
    h5: TextStyle?,
    h6: TextStyle?,
    subtitle1: TextStyle?,
    subtitle2: TextStyle?,
    body1: TextStyle?,
    body2: TextStyle?,
    button: TextStyle?,
    caption: TextStyle?,
    overline: TextStyle?
): Typography {
    val defaults = Typography()
    return Typography(
        h1 = defaults.h1.merge(h1),
        h2 = defaults.h2.merge(h2),
        h3 = defaults.h3.merge(h3),
        h4 = defaults.h4.merge(h4),
        h5 = defaults.h5.merge(h5),
        h6 = defaults.h6.merge(h6),
        subtitle1 = defaults.subtitle1.merge(subtitle1),
        subtitle2 = defaults.subtitle2.merge(subtitle2),
        body1 = defaults.body1.merge(body1),
        body2 = defaults.body2.merge(body2),
        button = defaults.button.merge(button),
        caption = defaults.caption.merge(caption),
        overline = defaults.overline.merge(overline)
    )
}
