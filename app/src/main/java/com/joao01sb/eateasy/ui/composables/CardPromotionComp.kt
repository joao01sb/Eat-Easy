package com.joao01sb.eateasy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardPromotionComp(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(160.dp),
        shape = ShapeDefaults.Medium
    ) {
        Column {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPromotionCompPreview() {
    CardPromotionComp()
}