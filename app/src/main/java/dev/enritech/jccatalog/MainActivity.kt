package dev.enritech.jccatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.enritech.jccatalog.model.Routes
import dev.enritech.jccatalog.ui.theme.JCCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        composable(Routes.Screen1.route) { Screen1(navigationController) }
                        composable(Routes.Screen2.route) { Screen2(navigationController) }
                        composable(Routes.Screen3.route) { Screen3(navigationController) }
                        composable(Routes.Screen4.route) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getString("user")!!
                            )
                        }
                        composable(
                            Routes.Screen5.route,
                            arguments = listOf(navArgument("winnersCount") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getInt("winnersCount") ?: 0
                            )
                        }
                        composable(
                            Routes.Screen6.route,
                            arguments = listOf(navArgument("qualifiedUser") {
                                defaultValue = true
                            })
                        ) { backStackEntry ->
                            Screen6(
                                navigationController,
                                backStackEntry.arguments?.getBoolean("qualifiedUser")
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCCatalogTheme {
        CustomDialog(true) {}
    }
}
