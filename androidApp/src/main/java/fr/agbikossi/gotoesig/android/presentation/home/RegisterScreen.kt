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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fr.agbikossi.gotoesig.android.presentation.GoToEsigDestination
import fr.agbikossi.gotoesig.android.presentation.theme.GoToEsigTheme

@Composable
fun RegisterScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        TextField(value = "",
            onValueChange ={},
            label = { Text(text = "Firstname")},
            singleLine = true,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        TextField(value = "",
            onValueChange ={},
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        TextField(value = "",
            onValueChange ={},
            label = { Text(text = " Confirm Password")},
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Button(onClick = { navController.navigate(GoToEsigDestination.Login.route) }) {
            Text("Save")
        }
    }

}

@Preview
@Composable
fun RegisterScreenPreview() {
    val navController= rememberNavController()
    GoToEsigTheme {
        RegisterScreen(navController = navController)
    }
    
}