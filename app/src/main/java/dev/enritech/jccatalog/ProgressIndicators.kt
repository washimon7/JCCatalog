package dev.enritech.jccatalog

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressIndicators() {
    var isFetching by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(Modifier.height(16.dp))
        if (isFetching) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), color = Color(0xFF00a14e))
            Box(Modifier.height(16.dp))
            CircularProgressIndicator(color = Color(0xFF00a14e))
            Box(Modifier.height(16.dp))
        }
        Button(enabled = !isFetching, onClick = {
            isFetching = !isFetching
        }) {
            Text(text = if (isFetching) "Fetching" else "Fetch")
        }
    }
}

@Composable
fun MyAdvancedProgress() {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus, color = Color(0xFF00a14e))
        Box(modifier = Modifier.height(16.dp))
        Row {
            Button({ progressStatus += 0.1f }) {
                Text(text = "Increase")
            }
            Button({ progressStatus -= 0.1f }) {
                Text(text = "Decrease")
            }
        }
    }
}