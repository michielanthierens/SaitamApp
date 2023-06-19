package be.howest.ti.saitamapp.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import be.howest.ti.saitamapp.data.ProgressDatabase
import be.howest.ti.saitamapp.model.Navigation
import be.howest.ti.saitamapp.ui.tabs.Overview
import be.howest.ti.saitamapp.ui.tabs.Progress


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SaitamaNavigation(
    navController: NavHostController,
    modifier: Modifier,
    innerPadding: PaddingValues,
    database: ProgressDatabase,
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.PROGRESS.name, // Set the start destination
        modifier = modifier.padding(innerPadding)
    ) {
        composable(Navigation.SETTINGS.name) {
            // todo(settings)
        }
        composable(Navigation.PROGRESS.name) {
            Progress(database)
        }
        composable(Navigation.OVERVIEW.name) {
            Overview(database)
        }
    }
}