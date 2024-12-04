package com.example.navegacion.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacion.navegacion.AppScreen

@Composable
fun FirstScreen(navController: NavController) {
    FirstBody(navController)
}


@Composable
fun FirstBody(navController: NavController) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var dni by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Prueba Practica",
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            fontSize = 20.sp
                )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField( // He usado un outlinedTextField de un ejercicio anterior que solo necesitaba cambiar los nombres
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = dni,
            onValueChange = { dni = it },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (nombre.isBlank() || dni.isBlank() ) {
                nombre="No hay datos recibidos"
                dni ="No hay datos recibidos"
            } else {
                if (dni.length != 9|| !dni.substring(9).all { it.isLetter() } || !dni.substring(0,8).all { it.isDigit() }){
                    dni="DNI incorrecto"
                }else {
                    navController.navigate(route = AppScreen.SecondScreen.route + "/$nombre" + "/$dni")
                }

            }
        }) {
            Text("Iniciar Sesion")
        }

    }
}

