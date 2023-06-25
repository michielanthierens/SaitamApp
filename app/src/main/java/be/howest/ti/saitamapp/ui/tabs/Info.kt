package be.howest.ti.saitamapp.ui.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import be.howest.ti.saitamapp.R

@Composable
fun Info() {
    val expanded = remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.thankYou),
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h1
        )
        if (expanded.value) {
            Text(
                text = stringResource(R.string.goal),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(top = 8.dp)
            )
        } else {
            Text(
                text = stringResource(R.string.goal).take(30) + "...",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Text(
            text = if (expanded.value) stringResource(R.string.see_less) else stringResource(R.string.see_more),
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .clickable { expanded.value = !expanded.value }
                .padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))


        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(progressImages) { progressItem ->
                ProgressItem(progressItem)
            }
        }
    }
}


@Composable
fun ProgressItem(progressItem: ProgressItem) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(progressItem.imageRes),
            contentDescription = "Progress Image",
            modifier = Modifier.size(65.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "${progressItem.progress}% - ${progressItem.description}",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary
        )
    }
}

data class ProgressItem(val progress: Int, val imageRes: Int, val description: String)

val progressImages = listOf(
    ProgressItem(20, R.drawable.saitama1, "No Progress"),
    ProgressItem(40, R.drawable.saitama2, "Low Progress"),
    ProgressItem(60, R.drawable.saitama3, "Medium Progress"),
    ProgressItem(80, R.drawable.saitama4, "High Progress"),
    ProgressItem(100, R.drawable.saitama5, "Complete Progress")
)
