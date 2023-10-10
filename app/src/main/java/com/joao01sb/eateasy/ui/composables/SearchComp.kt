package com.joao01sb.eateasy.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.joao01sb.eateasy.R

@Composable
fun SearchComp(
    modifier: Modifier,
    textSearch: String,
    onValueChange: (str: String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = textSearch,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = "search")
        },
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_segment),
                contentDescription = null,
                tint = Color.Red
            )
        },
        shape = ShapeDefaults.Medium
    )
}

@Preview(showBackground = true)
@Composable
fun SearchCompPreview() {
    var x = "search"
    SearchComp(modifier = Modifier, textSearch = x ) {
        x = it
    }
}

