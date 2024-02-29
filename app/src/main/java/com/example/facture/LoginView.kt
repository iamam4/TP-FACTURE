package com.example.facture

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier

@Composable

fun LoginView(navHostController: NavHostController) {
    var context = LocalContext.current

    var login by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxSize()
        )

        Text(
            text = "Authentification",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        Spacer(
            modifier = Modifier
                .height(30.dp)
        )

        Text(
            text = "Login",
            fontWeight = FontWeight.Bold
        )

        TextField(
            value = login,
            onValueChange = { login = it },
            placeholder = {
                Text(
                    "Login"
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    "password"
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Button(onClick = {
            if (login == "etudiant" && password == "AzertY") {
                navHostController.navigate("calculator")

            }else {
                toast(context = context, message = "Identifiant ou mot de passe invalide")
            }
        }) {
            Text(
                text = "Connexion",
                fontSize = 15.sp
            )


        }


    }

}

fun toast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

