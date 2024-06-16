package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.ButtonBlue
import com.example.meditationuiapp.ui.theme.DarkerButtonBlue
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
            .padding(top = 30.dp)
    ) {
        GreetingSection(name = name)
        ChipSection(chips = listOf("Sweet sleep","Insomnia","Depression"))
    }
}

@Composable
fun GreetingSection(name: String) {
    Row(
        Modifier.fillMaxWidth().padding(15.dp),
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

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)){
        items(chips.size) {
            ChipItem(
                title = chips[it],
                backgroundColor = if (it == selectedChipIndex) ButtonBlue else DarkerButtonBlue
            ) {
                selectedChipIndex = it
            }
        }
    }
}

@Composable
fun ChipItem(
    title: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(10.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
    }
}