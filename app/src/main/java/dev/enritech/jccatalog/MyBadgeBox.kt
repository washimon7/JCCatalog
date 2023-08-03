package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyBadgeBox() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        BadgedBox(
            badge = {
                Badge(
                    backgroundColor = Color.Green,
                ) {
                    Text(text = "100")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star"
            )
        }
        Divider(modifier = Modifier.padding(vertical = 16.dp), thickness = 4.dp, color = Color.Black)
        BadgedBox(
            badge = {
                Badge(
                    backgroundColor = Color.Green,
                ) {
                    Text(text = "100")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star"
            )
        }
    }
}