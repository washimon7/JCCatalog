package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

@Composable
fun BasicSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
}

@Composable
fun AdvancedSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    Column {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}