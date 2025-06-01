package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joao01sb.eateasy.core.presentation.navigation.Destinations
import com.joao01sb.eateasy.core.presentation.theme.DarkGray
import com.joao01sb.eateasy.core.presentation.theme.PrimaryOrange
import com.joao01sb.eateasy.core.presentation.theme.SurfaceWhite
import com.joao01sb.eateasy.core.presentation.theme.TextSecondary
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.fill.CreditCard

@Preview
@Composable
fun BottomNavigationBarCompose(
    onClickHome: () -> Unit = {},
    onClickRequests: () -> Unit = {},
    onClickShoppingCart: () -> Unit = {},
    onClickMessage: () -> Unit = {},
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = SurfaceWhite,
        contentColor = SurfaceWhite
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Início",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Início") },
            selected = currentRoute == Destinations.HomeScreen.route,
            onClick = onClickHome,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = SurfaceWhite,
                indicatorColor = PrimaryOrange,
                unselectedIconColor = DarkGray,
                selectedTextColor = TextSecondary
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    EvaIcons.Fill.CreditCard,
                    contentDescription = "Pedidos",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Pedidos") },
            selected = currentRoute == Destinations.Requests.route,
            onClick = onClickRequests,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = SurfaceWhite,
                indicatorColor = PrimaryOrange,
                unselectedIconColor = DarkGray,
                selectedTextColor = TextSecondary
            )

        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "Carrinho",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Carrinho") },
            selected = currentRoute == Destinations.CartScreen.route,
            onClick = onClickShoppingCart,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = SurfaceWhite,
                indicatorColor = PrimaryOrange,
                unselectedIconColor = DarkGray,
                selectedTextColor = TextSecondary
            )

        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "Mensagem",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Mensagem") },
            selected = currentRoute == Destinations.MessageScreen.route,
            onClick = onClickMessage,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = SurfaceWhite,
                indicatorColor = PrimaryOrange,
                unselectedIconColor = DarkGray,
                selectedTextColor = TextSecondary
            )

        )

    }
}