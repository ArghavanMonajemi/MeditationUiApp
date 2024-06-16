package com.example.meditationuiapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationuiapp.ui.theme.*
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
        ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
        CurrentMeditationSection(title = "Daily Thought", duration = "3-10 min")
        FeaturedSection(
            listOf(
                Feature(
                    title = "Sleep meditation",
                    iconId = R.drawable.ic_headphone,
                    lightColor = BlueViolet1,
                    mediumColor = BlueViolet2,
                    darkColor = BlueViolet3
                ),
                Feature(
                    title = "Tips for sleeping",
                    iconId = R.drawable.ic_videocam,
                    lightColor = LightGreen1,
                    mediumColor = LightGreen2,
                    darkColor = LightGreen3
                ),
                Feature(
                    title = "Night island",
                    iconId = R.drawable.ic_headphone,
                    lightColor = Beige1,
                    mediumColor = Beige2,
                    darkColor = Beige3
                ),
                Feature(
                    title = "Calming sounds",
                    iconId = R.drawable.ic_headphone,
                    lightColor = OrangeYellow3,
                    mediumColor = OrangeYellow2,
                    darkColor = OrangeYellow1
                )
            )
        )
    }
}

@Composable
fun GreetingSection(name: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp),
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
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
    ) {
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

@Composable
fun CurrentMeditationSection(
    title: String,
    duration: String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Meditation . $duration",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = stringResource(
                    id = R.string.play_icon
                ),
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}

@Composable
fun FeaturedSection(features: List<Feature>) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 100.dp)
    ) {
        Text(
            text = stringResource(id = R.string.feature),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = TextWhite
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth.toFloat()
        val height = constraints.maxHeight.toFloat()

        //Medium color path
        val mediumColorPoint1 = Offset(0f, 0.3f * height)
        val mediumColorPoint2 = Offset(0.1f * width, 0.35f * height)
        val mediumColorPoint3 = Offset(0.35f * width, 0f)
        val mediumColorPoint4 = Offset(0.7f * width, 0.65f * height)
        val mediumColorPoint5 = Offset(1.5f * width, -0.6f * height)

        val pathMediumColor = Path().apply {
            moveTo(mediumColorPoint1.x, mediumColorPoint1.y)
            standardQuadraticTo(mediumColorPoint1, mediumColorPoint2)
            standardQuadraticTo(mediumColorPoint2, mediumColorPoint3)
            standardQuadraticTo(mediumColorPoint3, mediumColorPoint4)
            standardQuadraticTo(mediumColorPoint4, mediumColorPoint5)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }

        //Light color path
        val lightColorPoint1 = Offset(0f, 0.35f * height)
        val lightColorPoint2 = Offset(0.1f * width, 0.38f * height)
        val lightColorPoint3 = Offset(0.3f * width, 0.35f * height)
        val lightColorPoint4 = Offset(0.8f * width, 0.7f * height)
        val lightColorPoint5 = Offset(1.5f * width, -0.5f * height)

        val pathLightColor = Path().apply {
            moveTo(lightColorPoint1.x, lightColorPoint1.y)
            standardQuadraticTo(lightColorPoint1, lightColorPoint2)
            standardQuadraticTo(lightColorPoint2, lightColorPoint3)
            standardQuadraticTo(lightColorPoint3, lightColorPoint4)
            standardQuadraticTo(lightColorPoint4, lightColorPoint5)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(pathMediumColor, feature.mediumColor)
            drawPath(pathLightColor, feature.lightColor)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title, style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = feature.iconId),
                    contentDescription = feature.title,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(ButtonBlue)
                        .padding(vertical = 7.dp, horizontal = 15.dp), text = stringResource(id = R.string.start),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

fun Path.standardQuadraticTo(from: Offset, to: Offset) {
    quadraticBezierTo(from.x, from.y, (from.x + to.x) / 2, (from.y + to.y) / 2)
}