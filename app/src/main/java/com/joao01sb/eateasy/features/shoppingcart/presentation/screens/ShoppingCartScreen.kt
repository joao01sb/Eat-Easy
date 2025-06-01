package com.joao01sb.eateasy.features.shoppingcart.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joao01sb.eateasy.core.domain.mocks.MocksProducts.productsCart
import com.joao01sb.eateasy.core.presentation.composables.FoodHeader
import com.joao01sb.eateasy.core.presentation.composables.FoodMenuItem
import com.joao01sb.eateasy.core.presentation.composables.Header
import com.joao01sb.eateasy.core.presentation.theme.BackgroundGray
import com.joao01sb.eateasy.core.presentation.theme.DarkGray
import com.joao01sb.eateasy.core.presentation.theme.PrimaryOrange

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreen() {
    Surface(
        color = BackgroundGray
    ) {
        Column {
            Header(title = "Carrinho")
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                TextButton(onClick = {}) {
                    Text(
                        "Cancelar pedido",
                        color = PrimaryOrange,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp
                    )
                }
            }
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                val displayedCategories = mutableSetOf<String>()

                productsCart.forEach { pair ->
                    val category = pair.first
                    val product = pair.second

                    if (displayedCategories.add(category)) {
                        item {
                            FoodHeader(
                                cartegory = category,
                            ) { }
                        }
                    }
                    item {
                        FoodMenuItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 8.dp),
                            product.name,
                            product.especification,
                            0.1,
                            product.quantity,
                        )
                        if (product == productsCart.last().second) {
                            Spacer(modifier = Modifier.height(6.dp))
                        }
                    }
                }
            }

            // Seção total e botão continuar
            Surface(
                color = DarkGray
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Total: R$ 200,00",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "6 items",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF5722)
                        ),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(
                            text = "Continuar",
                            modifier = Modifier.padding(horizontal = 16.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}