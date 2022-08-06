package fr.agbikossi.gotoesig.android.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DrawerItem(
    item: GoToEsigDestination,
    selected: Boolean,
    onItemClick: (GoToEsigDestination) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = { onItemClick(item) })
        .height(48.dp)
        .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
           text = stringResource(id = item.titleId),
           style = MaterialTheme.typography.h5,
           color = if (selected) {
               MaterialTheme.colors.primary
           } else {
               MaterialTheme.colors.onBackground
           }
        )
    }
}