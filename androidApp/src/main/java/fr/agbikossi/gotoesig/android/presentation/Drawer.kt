package fr.agbikossi.gotoesig.android.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import fr.agbikossi.gotoesig.android.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoure = navBackStackEntry?.destination?.route
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(200.dp)
                    .clickable {
                        navController.navigate(GoToEsigDestination.Home.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    },
                painter = painterResource(id = R.drawable.ic_logoesigelec),
                contentDescription = stringResource(id = R.string.app_name)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        GoToEsigDestination.values().filter { it.hasMenuItem }.forEach { item ->
            DrawerItem(item = item,
                selected = item.route == currentRoure,
                onItemClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        }
    }
}