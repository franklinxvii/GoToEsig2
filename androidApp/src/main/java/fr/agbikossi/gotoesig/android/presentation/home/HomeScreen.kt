package fr.agbikossi.gotoesig.android.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fr.agbikossi.gotoesig.android.R
import fr.agbikossi.gotoesig.android.presentation.GoToEsigDestination
import fr.agbikossi.gotoesig.android.presentation.theme.GoToEsigTheme


@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF1CC2E2),
                        Color(0xFFA847F4),
                        Color(0xFFE613FD)

                    )
                )
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logoesigelec),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            stringResource(id = R.string.welcome_message).uppercase(),
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(stringResource(id = R.string.app_name).uppercase())
        Button(onClick = { navController.navigate(GoToEsigDestination.Register.route) }) {
            Text(stringResource(id = R.string.signup))
        }
        //TouchId Login
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    GoToEsigTheme {
        HomeScreen(navController)
    }
}
