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

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import red.torch.composeweather.R
import red.torch.composeweather.data.WeatherInfo

@Composable
fun HourlyTemperatureChart(
    hourlyWeatherInfo: List<WeatherInfo>,
) {
    val description = stringResource(id = R.string.hourly_temperature_chart_description)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .semantics(
                mergeDescendants = true
            ) {
                contentDescription = description
            }
    ) {
        val min = hourlyWeatherInfo.minOf { it.celsius }
        val max = hourlyWeatherInfo.maxOf { it.celsius }

        val composeLineColor = colors.primary.copy(alpha = 0.85f) // 要調整
        val composeCircleColor = colors.onBackground
        val canvasTextColor = colors.onBackground.toArgb()
        val canvasTypeface = ResourcesCompat.getFont(LocalContext.current, R.font.spartan_regular)

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 0.dp, vertical = 16.dp)
        ) {

            val hours = size.width / hourlyWeatherInfo.size
            val paintTextSize = 14.sp.toPx()

            val offsets = hourlyWeatherInfo.mapIndexed { index, weatherInfo ->
                Offset(
                    hours * index + hours / 2,
                    (1 - (weatherInfo.celsius - min) / (max - min).toFloat()) * (size.height - paintTextSize)
                )
            }

            val path = androidx.compose.ui.graphics.Path().apply {
                moveTo(offsets.first().x, offsets.first().y)
                (1 until offsets.size).forEach { index ->
                    lineTo(offsets[index].x, offsets[index].y)
                }
            }
            drawIntoCanvas { canvas ->
                canvas.drawPath(
                    path,
                    androidx.compose.ui.graphics.Paint().apply {
                        style = PaintingStyle.Stroke
                        color = composeLineColor
                        strokeWidth = 4.dp.toPx()
                        pathEffect = PathEffect.cornerPathEffect(24f)
                    }
                )

                val circlePaint = androidx.compose.ui.graphics.Paint().apply {
                    color = composeCircleColor
                }

                val textPaint = android.graphics.Paint().apply {
                    color = canvasTextColor
                    textSize = paintTextSize
                    typeface = canvasTypeface
                }

                hourlyWeatherInfo.asSequence().zip(offsets.asSequence())
                    .forEachIndexed { _, pair ->
                        val (weatherInfo, offset) = pair

                        if (weatherInfo.focus) {
                            canvas.drawCircle(
                                offset,
                                4.dp.toPx(),
                                circlePaint
                            )
                        }

                        canvas.nativeCanvas.drawText(
                            "${weatherInfo.celsius}°",
                            offset.x - paintTextSize / 2,
                            offset.y + paintTextSize * 1.5f,
                            textPaint
                        )
                    }
            }
        }
    }
}
