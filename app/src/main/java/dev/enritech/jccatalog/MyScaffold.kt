package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyScaffold() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "You have clicked $it"
                    )
                }
            }, onClickDriver = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        bottomBar = { MyBottomNavigation() },
        scaffoldState = scaffoldState,
        floatingActionButton = { MyFav() },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        drawerContent = {
            MyDrawer {
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        },
        drawerGesturesEnabled = false,
    ) { }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDriver: () -> Unit) {
    TopAppBar(
        title = { Text(text = "My App") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { onClickDriver() }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("Alert") }) {
                Icon(imageVector = Icons.Default.AddAlert, contentDescription = "alert")
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable {
        mutableStateOf(0)
    }


    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = if (index == 0) Icons.Filled.Home else Icons.Outlined.Home,
                contentDescription = "home"
            )
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = if (index == 1) Icons.Filled.Search else Icons.Outlined.Search,
                contentDescription = "search"
            )
        }, label = { Text(text = "Search") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = if (index == 2) Icons.Filled.LibraryMusic else Icons.Outlined.LibraryMusic,
                contentDescription = "library music"
            )
        }, label = { Text(text = "Library") })
    }
}

@Composable
fun MyFav() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color.Yellow,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        TextButton(
            modifier = Modifier
                .height(40.dp),
            onClick = { onCloseDrawer() },
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                text = "Settings", modifier = Modifier
                    .fillMaxWidth(), color = Color.Black
            )
        }
        TextButton(
            modifier = Modifier
                .height(40.dp),
            onClick = { onCloseDrawer() },
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                text = "Preferences", modifier = Modifier
                    .fillMaxWidth(), color = Color.Black
            )
        }
        TextButton(
            modifier = Modifier
                .height(40.dp),
            onClick = { onCloseDrawer() },
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                text = "About us", modifier = Modifier
                    .fillMaxWidth(), color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScaffoldPreview() {
    MyDrawer {}
}