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
package red.torch.composeweather.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import red.torch.composeweather.ui.list.WeatherListScreen
import red.torch.composeweather.viewmodel.WeatherListViewModel

@Composable
fun NavGraph() {
    NavHost(rememberNavController(), startDestination = "main") {
        composable(
            "main"
        ) {
            val viewModel = hiltNavGraphViewModel<WeatherListViewModel>()
            WeatherListScreen(viewModel)
        }
    }
}
