package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.MeditationUiAppTheme

@Preview
@Composable
fun HomeScreenPreview() {
    MeditationUiAppTheme {
        HomeScreen(name = "Arghavan")
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    name: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(top = 30.dp, start = 15.dp, end = 15.dp)
    ) {
        GreetingSection(name = name)
    }
}

@Composable
fun GreetingSection(name: String) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodySmall,
                color = AquaBlue
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(
                id = R.string.search_icon
            ),
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}