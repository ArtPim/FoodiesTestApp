package com.artpim.foodiesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.artpim.foodiesapp.screens.CartScreen
import com.artpim.foodiesapp.screens.HomeScreen
import com.artpim.foodiesapp.screens.ItemScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val sharedViewModel: SharedViewModel = viewModel()

            NavHost(navController = navController,
                startDestination = Routes.home_screen,
                builder = {
                    composable(Routes.home_screen) {
                        HomeScreen(navController, sharedViewModel)
                    }
                    composable(Routes.item_screen)
                    {
                        ItemScreen(navController, sharedViewModel)
                    }
                    composable(Routes.cart_screen)
                    {
                        CartScreen(navController, sharedViewModel)
                    }
                })
        }
    }
}

