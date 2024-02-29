package com.example.facture

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable

fun Navigation () {

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login" ){
        composable(route ="login"){
            LoginView(navController)
        }
        composable(route = "taxe"){
            Taxe(navController)
        }
        composable(route = "result/{res}",
            arguments = listOf(
                navArgument("res") {
                    type = NavType.StringType
                }
            )
        ){
            navBackStackEntry ->
                Result(navController,
                    res = navBackStackEntry.arguments?.getString("res").toString()
                )
            }

        }
    }

