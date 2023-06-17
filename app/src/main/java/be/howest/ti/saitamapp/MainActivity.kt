package be.howest.ti.saitamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import be.howest.ti.saitamapp.ui.SaitamApp
import be.howest.ti.saitamapp.ui.theme.SaitamAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SaitamAppTheme {
                SaitamApp()
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SaitamAppTheme {
        SaitamApp()
    }
}