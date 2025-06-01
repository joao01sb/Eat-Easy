package com.joao01sb.eateasy.features.shoppingcart.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joao01sb.eateasy.core.domain.mocks.MocksProducts.productsCart

@Preview(showBackground = true)
@Composable
fun DetailsScreen(
    onBackClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBackIos, null)
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("Detalhes do Pedido")
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            val displayedCategories = mutableSetOf<String>()
            // Itera sobre os produtos diretamente
            productsCart.forEach { pair ->
                val category = pair.first
                val product = pair.second

                // Verifica se a categoria já foi desenhada
                if (displayedCategories.add(category)) {
                    // Adiciona o cabeçalho da categoria
                    item {
                        Text(category)
                    }
                }
                item {
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("x${product.quantity}")
                        Text(product.name)
                        Text(product.price)
                    }
                    if (product == productsCart.last().second) {
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                }
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Forma de pagamento", textAlign = TextAlign.Start, fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Container para o logo e texto
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Mastercard logo
                Row {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Red, CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .offset(x = (-8).dp)
                            .background(Color(0xFFF57C00), CircleShape)
                    )
                }

                // Card number with asterisks - agora mais próximo do logo
                Spacer(modifier = Modifier.width(8.dp))  // Espaçamento reduzido
                Text(
                    text = "**** **** **** 5854",
                    fontSize = 16.sp,
                    letterSpacing = 1.sp,
                    color = Color.DarkGray
                )
            }

            // Change button
            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFFF57C00)
                )
            ) {
                Text(
                    "Mudar",
                    fontSize = 14.sp
                )
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

    }
}


