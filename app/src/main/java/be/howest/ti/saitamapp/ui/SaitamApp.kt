package be.howest.ti.saitamapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.howest.ti.saitamapp.model.Navigation
import be.howest.ti.saitamapp.R


@Composable
fun SaitamApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Navigation.valueOf(
        backStackEntry?.destination?.route ?: Navigation.PROGRESS.name
    )


    Scaffold (
        topBar = {
            SaitamaTopBar(currentScreenTitle = currentScreen.title)
        }){ innerPadding ->

        SaitamaNavigation(
            navController = navController,
            modifier = modifier,
            innerPadding = innerPadding,

        )
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1f))

            NavBar(

            )
        }
    }
}

@Composable
fun SaitamaTopBar (
    currentScreenTitle: Int,
    modifier : Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(currentScreenTitle),
            style = MaterialTheme.typography.h1
        )

    }
}

@Composable
fun NavBar (
    onSettingsClicked: () -> Unit = {},
    onProgressClicked: () -> Unit = {},
    onOverviewClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        NavItem(image = R.drawable.settings, onClick = onSettingsClicked)
        NavItem(image = R.drawable.progress, onClick = onProgressClicked)
        NavItem(image = R.drawable.overview, onClick = onOverviewClicked)
    }
}


@Composable
fun NavItem(
    onClick: () -> Unit = {},
    image: Int,
) {
    Button(onClick = onClick, elevation = null) {
        Image(painter = painterResource(id = image), contentDescription = when (image) {
            R.drawable.settings -> "Settings"
            R.drawable.progress -> "Progress"
            R.drawable.overview -> "Overview"
            else -> null
        })
    }
}
