package be.howest.ti.saitamapp.ui

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
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


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SaitamApp(
    context: Context,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    ) {
    val database = createDatabase(applicationContext = context)

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
            database = database
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1f))

            NavBar(
                onInfoClicked = { navController.navigate(Navigation.INFO.name )},
                onProgressClicked = { navController.navigate(Navigation.PROGRESS.name )},
                onOverviewClicked = { navController.navigate(Navigation.OVERVIEW.name )}
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
        Image(
            modifier = Modifier
                .size(80.dp)
                .padding(0.dp),
            painter = painterResource(id = R.drawable.saitama_icon),
            contentDescription = null
        )
        Text(
            text = stringResource(currentScreenTitle),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun NavBar (
    onInfoClicked: () -> Unit = {},
    onProgressClicked: () -> Unit = {},
    onOverviewClicked: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        NavItem(image = R.drawable.info, onClick = onInfoClicked)
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
            R.drawable.info -> "Info"
            R.drawable.progress -> "Progress"
            R.drawable.overview -> "Overview"
            else -> null
        })
    }
}
