package red.torch.composeweather.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import red.torch.composeweather.R
import red.torch.composeweather.data.DailyInfo

@Composable
fun TodayWeatherInfo(dailyInfo: DailyInfo) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            .semantics(
                mergeDescendants = true
            ) {
                contentDescription = "Today is March 23rd. Today's weather is rainy."
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_wi_day_rain),
            contentDescription = null,
            tint = MaterialTheme.colors.secondary,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            modifier = Modifier
                .height(56.dp)
                .width(1.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                stringResource(id = R.string.common_today),
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .paddingFromBaseline(top = 8.dp, bottom = 8.dp)
            )
            Text(
                dailyInfo.date,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .paddingFromBaseline(top = 8.dp, bottom = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(24.dp))
    }
}