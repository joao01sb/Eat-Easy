package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import com.joao01sb.eateasy.core.presentation.theme.MediumGray
import com.joao01sb.eateasy.core.presentation.theme.PrimaryOrange
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.ArrowBack

@Preview
@Composable
fun SearchQuery(
    modifier: Modifier = Modifier,
    query: String = "",
    placeholder: String = "",
    onChange:(String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = query,
        onValueChange = onChange,
        leadingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = EvaIcons.Outline.ArrowBack,
                    contentDescription = "back"
                )
            }
        },
        placeholder = {
            Text(placeholder)
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedBorderColor = Color.White,        // Quando tem foco
            unfocusedBorderColor = Color.White,     // Quando não tem foco
            cursorColor = MediumGray,               // Cor do cursor
            focusedTextColor = Color.Black         // Cor do texto
        )
    )
}