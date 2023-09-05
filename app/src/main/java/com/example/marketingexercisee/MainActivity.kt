package com.example.marketingexercisee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marketingexercisee.ui.KotlinFirstScreen
import com.example.marketingexercisee.ui.KotlinSecondScreen
import com.example.marketingexercisee.ui.theme.MarketingExerciseeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketingExerciseeTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "kotlinFirstScreen"
                ) {
                    composable("kotlinFirstScreen") {
                        KotlinFirstScreen(applicationContext, navController)
                    }
                    composable("kotlinSecondScreen") {
                        KotlinSecondScreen(navController)
                    }
                }
            }
        }
    }
}
