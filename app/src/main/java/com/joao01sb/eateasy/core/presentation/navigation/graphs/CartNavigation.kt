package com.joao01sb.eateasy.core.presentation.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.joao01sb.eateasy.core.presentation.navigation.Destinations
import com.joao01sb.eateasy.features.shoppingcart.presentation.screens.ShoppingCartScreen

fun NavGraphBuilder.cartGraph() {
    composable(
        route = Destinations.CartScreen.route
    ) {
        ShoppingCartScreen()
    }
}

fun NavController.navigateToShoppingCart(
    navOptions: NavOptions? = null
) {
    navigate(Destinations.CartScreen.route, navOptions)
}