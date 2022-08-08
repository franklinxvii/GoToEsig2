package fr.agbikossi.gotoesig.android.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import fr.agbikossi.gotoesig.android.R
import fr.agbikossi.gotoesig.android.presentation.GoToEsigDestination

@Composable
fun ProfileScreen(navController: NavController) {
    Column() {
        Image(painter = painterResource(id = R.drawable.ic_logoesigelec), contentDescription = null)

        Button(onClick = { navController.navigate(GoToEsigDestination.Profile.route) }) {
            Text("Edit")
        }
    }

}