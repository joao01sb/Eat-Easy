package com.joao01sb.eateasy.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joao01sb.eateasy.R


@Preview(showBackground = true)
@Composable
fun ProductHighlightCard(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .heightIn(130.dp, 160.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(Color.Black)
            .clip(MaterialTheme.shapes.medium)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Spacer(Modifier.padding(start = 4.dp))
            Text(
                "Novo prato nas saladas",
                fontSize = 11.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp, top = 18.dp)
            )
            Text(
                "Salada de Fargo             Abacate",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp, top = 6.dp)
            )
            Text(
                "28,40",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(2.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(R.drawable.salad),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(end = 6.dp)
            )
        }
    }
}
