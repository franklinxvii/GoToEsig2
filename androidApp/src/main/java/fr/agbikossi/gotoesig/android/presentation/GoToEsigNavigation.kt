package fr.agbikossi.gotoesig.android.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.agbikossi.gotoesig.android.R
import fr.agbikossi.gotoesig.android.presentation.home.HomeScreen
import fr.agbikossi.gotoesig.android.presentation.home.LoginScreen
import fr.agbikossi.gotoesig.android.presentation.home.RegisterScreen
import fr.agbikossi.gotoesig.android.presentation.profile.ProfileScreen


@Composable
fun GoToEsigNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = GoToEsigDestination.Home.route, modifier = modifier) {
        composable(GoToEsigDestination.Home.route) {
            HomeScreen(navController)
        }
        composable(GoToEsigDestination.Register.route) {
            RegisterScreen(navController)
        }
        composable(GoToEsigDestination.Login.route) {
            LoginScreen(navController)
        }
        composable(GoToEsigDestination.Profile.route) {
            ProfileScreen(navController)
        }
    }

}


/**
 * Destinations used in [GoToEsigApp]
 */
enum class GoToEsigDestination(
    val route: String,
    val titleId: Int,
    val hasMenuItem: Boolean = true
) {
    Home("home", R.string.home, false),
    Register("register", R.string.register, false),
    Login("login", R.string.sign_in, false),
    Profile("profile", R.string.profile),
    AddTrip("addTrip", R.string.add_trip),
    Trips("trips", R.string.trips),
    SearchTrip("searchTrip", R.string.search_trip),
    RateTrip("rateTrip", R.string.rate_trip),
    Statistics("statistics", R.string.statistics),
    Quit("quit", R.string.quit),
}

/*
class GoToEsigNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(GoToEsigDestination.Home.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToProfile: () -> Unit = {
        navController.navigate(GoToEsigDestination.Profile.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToAddTrip: () -> Unit = {
        navController.navigate(GoToEsigDestination.AddTrip.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToTrips: () -> Unit = {
        navController.navigate(GoToEsigDestination.Trips.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToSearchTrip: () -> Unit = {
        navController.navigate(GoToEsigDestination.SearchTrip.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToRateTrip: () -> Unit = {
        navController.navigate(GoToEsigDestination.RateTrip.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToStatistics: () -> Unit = {
        navController.navigate(GoToEsigDestination.Statistics.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToQuit: () -> Unit = {
        navController.navigate(GoToEsigDestination.Quit.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
*/

