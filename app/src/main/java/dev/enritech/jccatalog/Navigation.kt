package dev.enritech.jccatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import dev.enritech.jccatalog.model.Routes

import dev.enritech.jccatalog.model.Routes.*

@Composable
fun Screen1(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 1")
        Text(
            text = "Ir a pantalla 2",
            modifier = Modifier.clickable { navigationController.navigate(Screen2.route) })
    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2")
        Text(
            text = "Ir a pantalla 3",
            modifier = Modifier.clickable { navigationController.navigate(Screen3.route) })
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 3")
        Text(
            text = "Ir a pantalla 4",
            modifier = Modifier.clickable {
                navigationController.navigate(
                    Screen4.createRoute(
                        "washimon7"
                    )
                )
            })
    }
}

@Composable
fun Screen4(navigationController: NavHostController, user: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 4")
        Text(text = "Hola $user")
        Text(
            text = "Ir a pantalla 5",
            modifier = Modifier.clickable {
                navigationController.navigate(
                    Screen5.createRoute(
                        2
                    )
                )
            })
    }
}

@Composable
fun Screen5(navigationController: NavHostController, winnersCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 5")
        Text(text = "Tenemos $winnersCount ganadores!")
        Text(
            text = "Ir a pantalla 6",
            modifier = Modifier.clickable { navigationController.navigate(Screen6.createRoute()) })
    }
}

@Composable
fun Screen6(navigationController: NavHostController, qualifiedUser: Boolean?) {
    println(qualifiedUser)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 6")
        if (qualifiedUser == true)
            Text(text = "Usted tiene un préstamo preaprobado") else
            Text(text = "¡Nos alegra tenerte con nosotros!")
        Text(
            text = "Ir a pantalla 1",
            modifier = Modifier.clickable { navigationController.navigate(Screen1.route) })
    }
}