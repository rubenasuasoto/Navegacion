package com.example.navegacion.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, nombre: String?, dni: String?){
    SecondBody(navController, nombre,dni)
}
@Composable
fun SecondBody(navController: NavController, nombre: String?, dni: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido $nombre", fontSize = 20.sp)
        Text("Se ha reguistrado correctamente su DNI: $dni", fontSize = 18.sp, textAlign = TextAlign.Center )
    }
}