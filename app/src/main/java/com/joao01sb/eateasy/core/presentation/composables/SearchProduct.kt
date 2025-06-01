package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joao01sb.eateasy.core.presentation.theme.LightGray
import com.joao01sb.eateasy.core.presentation.theme.PrimaryOrange
import com.joao01sb.eateasy.core.presentation.theme.TextBlack

@Composable
fun SearchProduct(
    text: String,
    onSearch: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp),
        value = text,
        onValueChange = onSearch,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = LightGray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.MenuOpen,
                contentDescription = null,
                tint = PrimaryOrange
            )
        },
        label = {
            Text(text = "search", color = LightGray)
        },
        shape = RoundedCornerShape(35),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            disabledIndicatorColor = Color.LightGray,
            focusedContainerColor = Color.White,
            focusedTextColor = TextBlack
        )
    )
}

@Preview
@Composable
fun SearchProductPreview() {
    SearchProduct("")
}