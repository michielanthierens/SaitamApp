package be.howest.ti.saitamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import be.howest.ti.saitamapp.ui.SaitamApp
import be.howest.ti.saitamapp.ui.theme.SaitamAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SaitamAppTheme {
                SaitamApp(context = applicationContext)
            }
        }
    }
}
