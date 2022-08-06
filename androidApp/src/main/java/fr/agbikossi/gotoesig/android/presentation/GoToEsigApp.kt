package fr.agbikossi.gotoesig.android.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import fr.agbikossi.gotoesig.android.R
import fr.agbikossi.gotoesig.android.presentation.theme.GoToEsigTheme
import kotlinx.coroutines.launch

@Composable
fun GoToEsigApp(
//    widthSizeClass: WindowWidthSizeClass
) {
    GoToEsigTheme {
        val systemUiController = rememberSystemUiController()
        val darkIcons = MaterialTheme.colors.isLight
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons)
        }
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        val titleId = when (currentRoute) {
                            GoToEsigDestination.Profile.route -> GoToEsigDestination.Profile.titleId
                            GoToEsigDestination.AddTrip.route -> GoToEsigDestination.AddTrip.titleId
                            GoToEsigDestination.Trips.route -> GoToEsigDestination.Trips.titleId
                            GoToEsigDestination.SearchTrip.route -> GoToEsigDestination.SearchTrip.titleId
                            GoToEsigDestination.RateTrip.route -> GoToEsigDestination.RateTrip.titleId
                            GoToEsigDestination.Statistics.route -> GoToEsigDestination.Statistics.titleId
                            GoToEsigDestination.Quit.route -> GoToEsigDestination.Quit.titleId
                            else -> R.string.app_name
                        }
                        Text(stringResource(id = titleId))
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = stringResource(
                                    id = R.string.menu
                                )
                            )
                        }
                    }
                )
            },
            drawerContent = {
                Drawer(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    navController = navController
                )
            },
            snackbarHost = {
                SnackbarHost(it) { data -> Snackbar(snackbarData = data) }
            }
        ) { contentPadding ->
            GoToEsigNavigation(
                navController = navController,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}
/*
@Composable
fun GoToEsigApp(
    widthSizeClass: WindowWidthSizeClass
) {
    GoToEsigTheme {
        val systemUiController = rememberSystemUiController()
        val darkIcons = MaterialTheme.colors.isLight
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons)
        }

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            GoToEsigNavigationActions(navController)
        }
        val coroutineScope = rememberCoroutineScope()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: GoToEsigDestination.Home.route
        val isExpandedScreen = widthSizeClass == WindowWidthSizeClass.Expanded
        val sizeAwareDrawerState = rememberSizeAwareDrawerState(isExpandedScreen)
        val scaffoldState = rememberScaffoldState()
            GoToEsigNavGraph(
                isExpandedScreen = false,
            )



       */
/* ModalDrawer(
            drawerContent = {
                AppDrawer(
                    currentRoute = currentRoute,
                    navigateToProfile = navigationActions.navigateToProfile,
/*
                    navigateToAddTrip = navigationActions.navigateToAddTrip,
                    navigateToTrips = navigationActions.navigateToTrips,
                    navigateToSearchTrip = navigationActions.navigateToSearchTrip,
                    navigateToRateTrip = navigationActions.navigateToRateTrip,
                    navigateToStatistics = navigationActions.navigateToStatistics,
                    navigateToQuit = navigationActions.navigateToQuit,
*//*

                    closeDrawer = {coroutineScope.launch { sizeAwareDrawerState.close() }},
                    modifier = Modifier
                        .statusBarsPadding()
                        .navigationBarsPadding()
                )

            },
            drawerState = sizeAwareDrawerState,
            gesturesEnabled = !isExpandedScreen
        ){
            Row(
                Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .windowInsetsPadding(
                        WindowInsets
                            .navigationBars
                            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top )

                    )
            ){
                if (isExpandedScreen){
                    AppNavRail(
                        currentRoute = currentRoute,
                        navigateToProfile = navigationActions.navigateToProfile,
                      //  navigateToAddtrip = navigationActions.navigateToAddTrip,
                    )
                }
                GoToEsigNavGraph(
                    isExpandedScreen = isExpandedScreen,
                    navController = navController,
                    openDrawer = {coroutineScope.launch{sizeAwareDrawerState.open()}},
                )
            }

        }*/



    }
}

@Composable
private fun rememberSizeAwareDrawerState(isExpandedScreen: Boolean): DrawerState {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    return if (!isExpandedScreen){
        drawerState
    }
    else {
        DrawerState(DrawerValue.Closed)
    }
}

@Composable
fun rememberContentPaddingForScreen (additionalTop: Dp = 0.dp) =
    WindowInsets.systemBars
        .only(WindowInsetsSides.Bottom)
        .add(WindowInsets(top = additionalTop))
        .asPaddingValues()

*/
