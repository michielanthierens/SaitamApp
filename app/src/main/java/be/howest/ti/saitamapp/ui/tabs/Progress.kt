package be.howest.ti.saitamapp.ui.tabs

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

@Composable
fun Progress(

) {
    // temp, fetch from database
    var progress by remember { mutableStateOf(0)}

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
                Button(onClick = { progress += 1 }) {
                    Text(text = "+1")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { progress += 10 }) {
                    Text(text = "+10")
                }
            }
        }
    }
}