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
package red.torch.composeweather.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import red.torch.composeweather.R

enum class Weather(
    val key: String,
    @DrawableRes val icon: Int,
    @StringRes val description: Int
) {
    Sunny(
        key = "sunny",
        icon = R.drawable.ic_wi_day_sunny,
        description = R.string.common_sunny
    ),
    SunnyThenCloudy(
        key = "sunny_then_cloudy",
        icon = R.drawable.ic_wi_day_cloudy,
        description = R.string.common_sunny_then_cloudy
    ),
    SunnyThenRainy(
        key = "sunny_then_rainy",
        icon = R.drawable.ic_wi_day_rainy,
        description = R.string.common_sunny_then_rainy
    ),
    Cloudy(
        key = "cloudy",
        icon = R.drawable.ic_wi_cloudy,
        description = R.string.common_cloudy
    ),
    CloudyThenSunny(
        key = "cloudy_then_sunny",
        icon = R.drawable.ic_wi_day_cloudy,
        description = R.string.common_cloudy_then_sunny
    ),
    Rainy(
        key = "rainy",
        icon = R.drawable.ic_wi_rainy,
        description = R.string.common_rainy
    ),
    RainyThenSunny(
        key = "rainy_then_sunny",
        icon = R.drawable.ic_wi_day_rainy,
        description = R.string.common_rainy_then_sunny
    )
    ;

    companion object {
        fun find(key: String): Weather {
            return values().find { it.key == key } ?: error("Not Found Weather")
        }
    }
}
