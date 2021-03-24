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

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import red.torch.composeweather.data.repository.FakeWeatherRepository
import red.torch.composeweather.ui.MainActivity
import red.torch.composeweather.ui.theme.MyTheme
import red.torch.composeweather.viewmodel.WeatherListViewModel

class WeatherListScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun hasTextAndDescriptionTest() {
        val viewModel = WeatherListViewModel(FakeWeatherRepository())

        // given
        composeTestRule.setContent {
            MyTheme {
                WeatherListScreen(viewModel)
            }
        }

        // composeTestRule.onRoot().printToLog("TAG")

        // Title
        composeTestRule.onAllNodes(hasText("Weather Forecast"))
        composeTestRule.onNodeWithText("Weather Forecast").assertIsDisplayed()

        // Daily Info
        composeTestRule.onNodeWithText("Today, Tue, March 23").assertIsDisplayed()
        composeTestRule.onNodeWithText("16°").assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("The current temperature is 16°C")
            .assertIsDisplayed()

        // Hourly Info
        composeTestRule
            .onNodeWithContentDescription("Hourly Temperature Chart")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("The weather at 12AM is sunny. The temperature is  18°C") // ? needs two space
            .assertIsDisplayed()
    }
}
