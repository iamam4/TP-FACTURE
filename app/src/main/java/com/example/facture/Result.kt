package com.example.facture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


@Composable

fun Result (navHostController: NavHostController, res: String) {
    Column( modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var total by remember {
            mutableStateOf(res)
        }

        Spacer ( modifier = Modifier.height(30.dp)
        )

        Text (
            text = "Montant Total",
            fontSize = 30.sp,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold
        )

        Spacer ( modifier = Modifier.height(30.dp)
        )

        TextField(value = total.toString(), onValueChange = {it}, enabled = false )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navHostController.navigate("Taxe")}) {
            Text (text = "Back")

        }
    }
}