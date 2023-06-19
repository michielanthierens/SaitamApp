package be.howest.ti.saitamapp.ui.tabs

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import be.howest.ti.saitamapp.R
import be.howest.ti.saitamapp.data.ProgressDao
import be.howest.ti.saitamapp.data.ProgressDatabase
import be.howest.ti.saitamapp.model.ProgressDay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Progress(
    database: ProgressDatabase
) {
    val dao = database.progressDao()
    val today = LocalDate.now().toString() // Get the current date
    var progress by remember { mutableStateOf(0) }
    Log.i("kilo", today)
    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val currentProgress = dao.getProgressDay(today)
            if (currentProgress == null) {
                val newProgress = ProgressDay(progress = 0, date = today)
                dao.addProgressDay(newProgress)
                progress = newProgress.progress
                Log.i("kilo", "create new entry")
            } else {
                progress = currentProgress.progress
                Log.i("kilo", "exsisting entry: " + currentProgress)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = progress.toString(), color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h1 )
            Box(
                modifier = Modifier
                    .size(350.dp)
                    .padding(16.dp)
            ) {
                CircularProgressIndicator(
                    progress = progress.toFloat() / 100,
                    modifier = Modifier
                        .fillMaxSize()
                        .rotate(-90f)
                )
                val iconRes = when {
                    progress >= 75 -> R.drawable.saitama4
                    progress >= 50 -> R.drawable.saitama3
                    progress >= 25 -> R.drawable.saitama2
                    else -> R.drawable.saitama1
                }
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = "Progress Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    progress += 1
                    val entry = ProgressDay(progress = progress, date = today)
                    CoroutineScope(Dispatchers.IO).launch {
                        dao.update(entry)
                    }
                }) {
                    Text(text = "+1")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    progress += 10
                    val entry = ProgressDay(progress = progress, date = today)
                    CoroutineScope(Dispatchers.IO).launch {
                        dao.update(entry)
                    }
                }) {
                    Text(text = "+10")
                }
            }
        }
    }
}