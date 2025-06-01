package com.joao01sb.eateasy.core.presentation.navigation

sealed class Destinations(val route: String) {
    data object CartScreen : Destinations("cart_screen")
    data object HomeGraph : Destinations("home_graph")
    data object HomeScreen : Destinations("home_screen")
    data object Requests : Destinations("requests_screen")
    data object MessageScreen : Destinations("message_screen")
}