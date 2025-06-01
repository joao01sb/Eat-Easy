package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joao01sb.eateasy.core.presentation.theme.LightGray
import com.joao01sb.eateasy.core.presentation.theme.TextBlack
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.ArrowIosBack


@Preview
@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String = ""
) {
    Column{
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = EvaIcons.Outline.ArrowIosBack,
                    contentDescription = "Back",
                    tint = TextBlack
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.Center),
                color = TextBlack
            )
        }
        HorizontalDivider(color = LightGray, modifier = Modifier.padding(horizontal = 10.dp))
    }

}