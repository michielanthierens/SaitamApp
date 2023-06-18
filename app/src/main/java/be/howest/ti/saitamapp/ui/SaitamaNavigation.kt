package be.howest.ti.saitamapp.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import be.howest.ti.saitamapp.model.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import be.howest.ti.saitamapp.ui.tabs.Progress


@Composable
fun SaitamaNavigation(
    navController: NavHostController,
    modifier: Modifier,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.PROGRESS.name, // Set the start destination
        modifier = modifier.padding(innerPadding)
    ) {
        composable(Navigation.SETTINGS.name) {
            Text(text = "test1")


        }
        composable(Navigation.PROGRESS.name) {
            Progress()

        }
        composable(Navigation.OVERVIEW.name) {
            Text(text = "test3")


        }
    }
}