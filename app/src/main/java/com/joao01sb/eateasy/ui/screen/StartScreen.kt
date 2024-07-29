package com.joao01sb.eateasy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dehaze
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun StartScreen() {
    Scaffold(
        bottomBar = {

        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            var text by remember {
                mutableStateOf("")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.weight(0.2f),
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
                Text(modifier = Modifier.weight(0.8f), text = "Gram Bistro", fontSize = 16.sp)
                Icon(
                    modifier = Modifier.weight(0.2f),
                    imageVector = Icons.Filled.Dehaze,
                    contentDescription = null
                )
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Escolha o melhor prato para você!",
                fontSize = 23.sp,
                fontWeight = FontWeight.W400
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                value = text,
                onValueChange = { newText -> text = newText; },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.MenuOpen,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = "search")
                }
            )
        }
    }
}
