package dev.enritech.jccatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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