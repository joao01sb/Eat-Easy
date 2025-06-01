package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joao01sb.eateasy.core.presentation.theme.LightGray
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.fill.Menu2

@Composable
fun SearchLocationAndOptions(
    modifier: Modifier = Modifier,
    onLocationClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.weight(0.2f),
                imageVector = Icons.Filled.LocationOn,
                contentDescription = null,
                tint = LightGray
            )
            Text(
                modifier = Modifier.weight(0.8f),
                text = "Eat Easy",
                fontSize = 16.sp,
                color = LightGray
            )
            Icon(
                modifier = Modifier.weight(0.2f),
                imageVector = EvaIcons.Fill.Menu2,
                contentDescription = null,
                tint = LightGray
            )
        }
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 10.dp))
}

@Preview
@Composable
fun SearchLocationAndOptionsPreviiew() {
    SearchLocationAndOptions()
}
