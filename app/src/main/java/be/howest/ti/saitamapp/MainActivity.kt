package be.howest.ti.saitamapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import be.howest.ti.saitamapp.ui.SaitamApp
import be.howest.ti.saitamapp.ui.theme.SaitamAppTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SaitamAppTheme {
                SaitamApp(context = applicationContext)
            }
        }
    }
}
