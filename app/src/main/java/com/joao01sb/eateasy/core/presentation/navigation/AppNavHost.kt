package com.joao01sb.eateasy.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joao01sb.eateasy.core.presentation.navigation.graphs.cartGraph
import com.joao01sb.eateasy.core.presentation.navigation.graphs.homeGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.HomeGraph.route
    ) {
        homeGraph()
        cartGraph()
    }
}