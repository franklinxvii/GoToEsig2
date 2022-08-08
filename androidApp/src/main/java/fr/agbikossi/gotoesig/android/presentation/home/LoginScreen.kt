package fr.agbikossi.gotoesig.android.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fr.agbikossi.gotoesig.android.R
import fr.agbikossi.gotoesig.android.presentation.GoToEsigDestination

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Firstname") },
            singleLine = true,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Button(onClick = { navController.navigate(GoToEsigDestination.Profile.route) }) {
            Text(stringResource(id = R.string.sign_in))
        }
    }

}