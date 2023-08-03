package dev.enritech.jccatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.enritech.jccatalog.ui.TodoInfo
import dev.enritech.jccatalog.ui.theme.JCCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCCatalogTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MyDropdownMenu()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCCatalogTheme {
        MyDropdownMenu()
    }
}

@Composable
fun MyDropdownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf<String>("Ice Cream", "Chocolate", "Candy", "Cupcake", "Donut")

    Column(
        Modifier
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            label = { Text("Select a dessert") },
            enabled = false,
            readOnly = true,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth())
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            desserts.forEach { dessert ->
                DropdownMenuItem(onClick = { selectedText = dessert; expanded = false }) {
                    Text(text = dessert)
                }
            }
        }
    }
}