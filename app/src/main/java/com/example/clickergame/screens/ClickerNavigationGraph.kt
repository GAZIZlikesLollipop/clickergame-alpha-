package com.example.clickergame.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clickergame.data.ClickerViewModel

@Composable
fun ClickerNavigationGraph(

){
    val navController = rememberNavController()
    val viewModel: ClickerViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.GAME_SCREEN){
        composable(Routes.GAME_SCREEN){
            GameScreen(
                navController = navController,
                ViewModel = viewModel
            )
        }
        composable(Routes.SHOP_SCREEN){
            ShopScreen(
                navController = navController,
                ViewModel = viewModel
            )
        }
        composable(Routes.SETTINGS_SCREEN){
            SettingsScreen(ViewModel = viewModel)
        }
    }
}
