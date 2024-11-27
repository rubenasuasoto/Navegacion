package com.example.navegacion.navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.Screens.FirstScreen
import com.example.navegacion.Screens.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.FirstScreen.route) {
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(
            route = AppScreen.SecondScreen.route + "/{dni}/{nombre}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("dni") { type = NavType.StringType }

            )
        ) { backStackEntry ->
            val dni = backStackEntry.arguments?.getString("dni")
            val nombre = backStackEntry.arguments?.getString("nombre")
            SecondScreen(navController, dni, nombre)
        }
    }
}