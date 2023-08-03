package dev.enritech.jccatalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                println("Enviando..")
                enabled = false
            },
            modifier = Modifier.height(44.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green,
                contentColor = Color.DarkGray
            ),
            border = BorderStroke(width = 4.dp, color = Color.Blue),
            enabled = enabled,
        ) {
            Text(text = "Enviar")
        }
    }
}

@Composable
fun MyButtons() {
    var buttonIsEnabled by remember {
        mutableStateOf(true)
    }
    var outlinedButtonIsEnabled by remember {
        mutableStateOf(true)
    }
    var textButtonIsEnabled by remember {
        mutableStateOf(true)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedButton(
            onClick = {
                println("Enviando..")
                outlinedButtonIsEnabled = false
            },
            modifier = Modifier.height(44.dp),
            enabled = outlinedButtonIsEnabled,
        ) {
            Text(text = "Enviar")
        }
        Box(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                println("Enviando..")
                buttonIsEnabled = false
            },
            modifier = Modifier.height(44.dp),
            enabled = buttonIsEnabled,
        ) {
            Text(text = "Enviar")
        }
        Box(modifier = Modifier.height(16.dp))
        TextButton(
            onClick = {
                println("Enviando..")
                textButtonIsEnabled = false
            },
            modifier = Modifier.height(44.dp),
            enabled = textButtonIsEnabled,
        ) {
            Text(text = "Enviar")
        }
    }
}
