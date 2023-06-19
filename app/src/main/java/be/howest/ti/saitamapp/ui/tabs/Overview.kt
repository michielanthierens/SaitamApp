package be.howest.ti.saitamapp.ui.tabs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import be.howest.ti.saitamapp.data.ProgressDatabase
import be.howest.ti.saitamapp.model.ProgressDay
import be.howest.ti.saitamapp.ui.theme.lightYellow
import be.howest.ti.saitamapp.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Overview(
    database: ProgressDatabase,
    modifier: Modifier = Modifier
) {
    val dao = database.progressDao()
    val allProgressDays by dao.getAllProgressDays().collectAsState(emptyList())

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (allProgressDays.isEmpty()) {
            Text(
                text = "No progress recorded.",
                style = MaterialTheme.typography.subtitle1
            )
        } else {
            LazyColumn {
                items(allProgressDays) { progressDay ->
                    ProgressDayItem(progressDay = progressDay)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProgressDayItem(progressDay: ProgressDay) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        backgroundColor = lightYellow,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val iconRes = when {
                progressDay.progress >= 75 -> R.drawable.saitama4
                progressDay.progress >= 50 -> R.drawable.saitama3
                progressDay.progress >= 25 -> R.drawable.saitama2
                else -> R.drawable.saitama1
            }
            val formatter = DateTimeFormatter.ofPattern("dd MMM", Locale.getDefault())
            val date = LocalDate.parse(progressDay.date)
            val formattedDate = date.format(formatter)
            Text(
                text = formattedDate,
                color = Color.Black,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(iconRes),
                contentDescription = "Progress Icon",
                tint = Color.Unspecified,
                modifier = Modifier.padding(end = 16.dp).size(75.dp),
            )
        }
    }
}
