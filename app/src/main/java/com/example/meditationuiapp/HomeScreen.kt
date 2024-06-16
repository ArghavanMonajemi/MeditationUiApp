package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Box(modifier = modifier
        .fillMaxSize()
        .background(DeepBlue)){

    }
}