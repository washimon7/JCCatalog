package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField() {
    var userName by remember {
        mutableStateOf("")
    }

    TextField(
        value = userName,
        placeholder = { Text("Nombre de usuario") },
        maxLines = 1,
        onValueChange = {
            userName = it
        })
}

@Composable
fun MyAdvancedTextfield() {
    var userName by remember {
        mutableStateOf("")
    }

    TextField(value = userName, label = { Text(text = "Nombre de usuario") }, onValueChange = {
        userName =
            if (it.contains("a"))
                it.replace("a", "")
            else
                it
    })
}

@Composable
fun MyOutlinedTextfield() {
    var userName by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)
    ) {
        OutlinedTextField(
            value = userName,
            label = { Text("Nombre de usuario") },
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.Blue,
                cursorColor = Color.Magenta
            ),
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                userName = it
            })
    }
}