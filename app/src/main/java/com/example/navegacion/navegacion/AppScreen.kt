package com.example.navegacion.navegacion

sealed class AppScreen(val route: String) {
    object FirstScreen: AppScreen("FirstScreen")
    object SecondScreen: AppScreen("SecondScreen")
}