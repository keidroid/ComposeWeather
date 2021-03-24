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
package red.torch.composeweather.ui.list.hourly

import android.os.Build
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.filters.SdkSuppress
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import red.torch.composeweather.assertScreenshotMatchesGolden
import red.torch.composeweather.data.Weather
import red.torch.composeweather.data.WeatherInfo
import red.torch.composeweather.ui.common.Background
import red.torch.composeweather.ui.theme.MyTheme

@ExperimentalTestApi
@SdkSuppress(minSdkVersion = Build.VERSION_CODES.O)
class DailyInfoSectionScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    @Ignore("Screenshot test is valid only when using Pixel 2 Emulator")
    fun darkScreenshot() {
        // NOTE: Canvas is Invisible
        compareTimeScreenshot(0, "hourly_info_section_dark", true)
    }

    @Test
    @Ignore("Screenshot test is valid only when using Pixel 2 Emulator")
    fun lightScreenshot() {
        // NOTE: Canvas is Invisible
        compareTimeScreenshot(0, "hourly_info_section_light", false)
    }

    private fun compareTimeScreenshot(timeMs: Long, goldenName: String, darkTheme: Boolean) {
        composeTestRule.mainClock.autoAdvance = false
        showScreen(darkTheme)
        composeTestRule.mainClock.advanceTimeBy(timeMs)
        assertScreenshotMatchesGolden(goldenName, composeTestRule.onRoot())
    }

    private fun showScreen(darkTheme: Boolean) {
        val dailyInfo = WeatherInfo(
            dateLabel = "4PM",
            weather = Weather.RainyThenSunny,
            celsius = 16,
        )
        val weeklyInfo = mutableListOf<WeatherInfo>().apply {
            repeat(7) {
                add(dailyInfo)
            }
        }.toList()
        composeTestRule.setContent {
            MyTheme(darkTheme = darkTheme) {
                Background {
                    HourlyInfoSection(weeklyInfo)
                }
            }
        }
    }
}
