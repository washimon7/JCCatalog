package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyRadioButtonList() {
    var selected by rememberSaveable { mutableStateOf("") }
    val options = listOf<String>("Aris", "Pedro", "Wanda", "Mateo")

    Column(modifier = Modifier.fillMaxSize()) {
        options.forEach {
            RadioButtonItem(selected = selected, value = it) { option -> selected = option }
        }
    }
}

@Composable
fun RadioButtonItem(selected: String, value: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == value, onClick = { onItemSelected(value) })
        Text(text = value)
    }
}