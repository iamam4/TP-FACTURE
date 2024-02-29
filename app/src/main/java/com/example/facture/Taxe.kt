package com.example.facture

import android.opengl.ETC1.isValid
import android.text.method.TextKeyListener.clear

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable

fun Taxe( navHostController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        var quantity by remember {
            mutableStateOf("")
        }

        var priceUnitary by remember {
            mutableStateOf("")
        }

        var montantHt by remember {
            mutableStateOf("")
        }

        var tva by remember {
            mutableStateOf("")
        }

        var montant by remember {
            mutableStateOf("")
        }

        var fidele by remember {
            mutableStateOf(false)
        }

        var res by remember {
            mutableStateOf(0)
        }

        fun clearAll() {
            quantity = ""
            priceUnitary = ""
            montantHt = ""
            tva = ""
            montant = ""
            fidele = false

        }

        fun calcul(){
            var quantity = quantity.toInt()
            var priceUnitary = priceUnitary.toInt()


            if (fidele){
                var montant = montant.toInt()
                res = quantity * priceUnitary - montant
            }
            else {
                res = quantity * priceUnitary
            }
            navHostController.navigate("result/$res")
        }

        fun Valid(): Boolean {
            return (quantity != "" && priceUnitary != "")
        }

        Spacer(modifier = Modifier
            .height(30.dp)
            .fillMaxSize()
        )

        Text(
            text = "FACTURE",
            fontSize = 32.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier
            .height(20.dp)
            .fillMaxSize()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Quantité", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.width(20.dp))

            TextField(value = quantity, onValueChange = {quantity = it})
        }

        Spacer(modifier =
        Modifier
            .height(10.dp)
            .fillMaxSize()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Prix unitaire", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.width(20.dp))

            TextField(value = priceUnitary, onValueChange = {priceUnitary = it})
        }

        Spacer(modifier =
        Modifier
            .height(20.dp)
            .fillMaxSize()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "TVA", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.width(20.dp))

            TextField(value = tva, onValueChange = {tva = it})
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = fidele, onClick = {
                fidele = true
            })
            Text(
                text = "Fidèle",
                modifier = Modifier.padding(start = 8.dp)
            )



            RadioButton(selected = !fidele, onClick = {
                fidele = false
            })
            Text(
                text = "Non fidèle",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier =
        Modifier
            .height(20.dp)
            .fillMaxSize()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Remise", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.width(10.dp))

            TextField(value = montant, onValueChange = {montant = it}, enabled = fidele)
        }


        Row {
            Button(onClick = {calcul()}, enabled = Valid()
            ) {
                Text(text = "Calculer TTC")
            }


            Button(onClick = { clearAll() }) {
                Text(text = "Réinitialiser")
            }
        }


    }
}