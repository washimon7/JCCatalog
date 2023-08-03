package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyIcons() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row() {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Star icon",
                tint = Color(0xFFfcbc00)
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Star icon",
                tint = Color(0xFFfcbc00)
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Star icon",
                tint = Color(0xFFfcbc00)
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Star icon",
                tint = Color.LightGray
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Star icon",
                tint = Color.LightGray
            )
        }
    }
}