package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.joao01sb.eateasy.R
import com.joao01sb.eateasy.core.presentation.theme.DarkGray
import com.joao01sb.eateasy.core.presentation.theme.EatEasyTheme
import com.joao01sb.eateasy.core.presentation.theme.LightGray
import com.joao01sb.eateasy.core.presentation.theme.PrimaryOrange

@Composable
fun ProductCard(name: String, price: String, imageUrl: String) {
    EatEasyTheme {
        Card(
            modifier = Modifier
                .width(130.dp)
                .height(190.dp), // Altura reduzida para ficar mais compacto
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(0.3.dp, LightGray)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp) // altura total do box reduzida
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.TopEnd) // canto superior esquerdo
                            .padding(top = 4.dp, end = 8.dp, bottom = 4.dp)
                            .background(PrimaryOrange, RoundedCornerShape(30))
                    )

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imageUrl)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .align(Alignment.BottomCenter) // imagem abaixo do botão
                            .padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = 6.dp)
                            .height(80.dp) // imagem menor
                            .fillMaxWidth()
                            .clip(CircleShape)

                    )
                }

                HorizontalDivider(color = LightGray, modifier = Modifier.padding(horizontal = 8.dp))

                Column(
                    modifier = Modifier
                        .padding(bottom = 4.dp, top = 4.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy((-8).dp)
                ) {
                    Text(
                        text = price,
                        fontSize = 13.sp,
                        color = PrimaryOrange,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = name,
                        fontSize = 12.sp,
                        color = DarkGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Categoria",
                        fontSize = 10.sp,
                        color = LightGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    ProductCard(
        name = "Salada Franga 2",
        price = "R$ 15,00",
        imageUrl = "https://www.designi.com.br/images/preview/11110296.jpg"
    )
}