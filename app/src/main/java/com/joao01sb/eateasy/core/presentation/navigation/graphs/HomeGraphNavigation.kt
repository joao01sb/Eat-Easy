package com.joao01sb.eateasy.core.presentation.navigation.graphs

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.joao01sb.eateasy.core.presentation.navigation.Destinations
import com.joao01sb.eateasy.features.home.presentation.screens.HomeScreen
import com.joao01sb.eateasy.features.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel


fun NavGraphBuilder.homeGraph() {
    navigation(
        startDestination = Destinations.HomeScreen.route,
        route = Destinations.HomeGraph.route
    ) {
        composable(
            route = Destinations.HomeScreen.route
        ) {
            val viewmModel = koinViewModel<HomeViewModel>()
            val state by viewmModel.homeState.collectAsStateWithLifecycle()
            HomeScreen(
                state,
                onSearch = viewmModel::onSearch
            )
        }
    }
}

fun NavController.navigateToHome(
    navOptions: NavOptions? = null
) {
    navigate(Destinations.HomeScreen.route, navOptions)
}