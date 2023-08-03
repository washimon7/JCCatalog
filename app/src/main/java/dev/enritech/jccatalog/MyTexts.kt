package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is an example")
        Text(text = "This is an example", color = Color.Blue)
        Text(text = "This is an example", color = Color.Blue, fontWeight = FontWeight.Medium)
        Text(
            text = "This is an example",
            color = Color.Magenta,
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(
            text = "This is an example",
            color = Color.Magenta,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "This is an example",
            color = Color.Magenta,
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "This is an example",
            color = Color.Magenta,
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            )
        )
        Text(text = "This is an example", fontSize = 20.sp)
    }

}