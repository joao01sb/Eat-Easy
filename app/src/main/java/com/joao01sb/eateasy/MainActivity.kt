package com.joao01sb.eateasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.joao01sb.eateasy.core.presentation.composables.BottomNavigationBarCompose
import com.joao01sb.eateasy.core.presentation.navigation.AppNavHost
import com.joao01sb.eateasy.core.presentation.navigation.graphs.navigateToHome
import com.joao01sb.eateasy.core.presentation.navigation.graphs.navigateToShoppingCart
import com.joao01sb.eateasy.core.presentation.theme.EatEasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EatEasyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartApp()
                }
            }
        }
    }

    @Composable
    private fun StartApp() {
        val navController = rememberNavController()

        Scaffold(
            containerColor = Color.White,
            bottomBar = {
                BottomNavigationBarCompose(
                    navController = rememberNavController(),
                    onClickHome = {
                        navController.navigateToHome()
                    },
                    onClickRequests = {

                    },
                    onClickShoppingCart = {
                        navController.navigateToShoppingCart()
                    },
                    onClickMessage = {

                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.padding(it)
            ) {
                AppNavHost(navController = navController)
            }
        }
    }
}
