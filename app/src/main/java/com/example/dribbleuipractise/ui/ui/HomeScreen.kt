package com.example.dribbleuipractise.ui.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dribbleuipractise.BottomMenuContent
import com.example.dribbleuipractise.Feature
import com.example.dribbleuipractise.R
import com.example.dribbleuipractise.standardQuadFromTo
import com.example.dribbleuipractise.theme.AquaBlue
import com.example.dribbleuipractise.theme.Beige1
import com.example.dribbleuipractise.theme.Beige2
import com.example.dribbleuipractise.theme.Beige3
import com.example.dribbleuipractise.theme.BlueViolet1
import com.example.dribbleuipractise.theme.BlueViolet2
import com.example.dribbleuipractise.theme.BlueViolet3
import com.example.dribbleuipractise.theme.ButtonBlue
import com.example.dribbleuipractise.theme.DarkerButtonBlue
import com.example.dribbleuipractise.theme.DeepBlue
import com.example.dribbleuipractise.theme.LightGreen1
import com.example.dribbleuipractise.theme.LightGreen2
import com.example.dribbleuipractise.theme.LightGreen3
import com.example.dribbleuipractise.theme.LightGrey1
import com.example.dribbleuipractise.theme.LightGrey2
import com.example.dribbleuipractise.theme.LightGrey3
import com.example.dribbleuipractise.theme.LightRed
import com.example.dribbleuipractise.theme.LightRed1
import com.example.dribbleuipractise.theme.LightRed2
import com.example.dribbleuipractise.theme.LightRed3
import com.example.dribbleuipractise.theme.OrangeYellow1
import com.example.dribbleuipractise.theme.OrangeYellow2
import com.example.dribbleuipractise.theme.OrangeYellow3
import com.example.dribbleuipractise.theme.TextWhite

@Composable
fun HomeScreen() {
    //Root container
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
            .padding(10.dp)
    ) {
        /*Here the main content of the screen will be placed one after another*/
        Column {
            GreetingSection()
            ChipSection(chip = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Concentration Boost",
                        R.drawable.ic_headphone,
                        LightGrey1,
                        LightGrey2,
                        LightGrey3
                    ),
                    Feature(
                        title = "Improve study",
                        R.drawable.ic_headphone,
                        LightRed1,
                        LightRed2,
                        LightRed3
                    )
                )
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home, "HomeIcon"),
                BottomMenuContent("Meditate", R.drawable.ic_bubble, "MeditateIcon"),
                BottomMenuContent("Sleep", R.drawable.ic_moon, "SleepIcon"),
                BottomMenuContent("Music", R.drawable.ic_music, "MusicIcon"),
                BottomMenuContent("Profile", R.drawable.ic_profile, "ProfileIcon"),
            ), modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingSection(
    name: String = "Aayush"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "We wish you a good day 💗",
                color = TextWhite,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            modifier = Modifier.size(20.dp),
            tint = TextWhite,
            contentDescription = "Search Icon",
            painter = painterResource(id = R.drawable.ic_search)
        )
    }
}


@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    usedBtnColor: Color = ButtonBlue,
    modifier: Modifier = Modifier,
    usedTextColor: Color = TextWhite,
    defaultTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .height(100.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = selectedItemIndex == index
            ) {
                selectedItemIndex = index
            }
        }
    }

}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    usedBtnColor: Color = ButtonBlue,
    usedTextColor: Color = TextWhite,
    defaultTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(if (isSelected) usedBtnColor else Color.Transparent)
                .padding(10.dp)
            /*.height(30.dp)
            .width(30.dp),*/,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = item.IconId),
                contentDescription = item.contentDescription,
                tint = if (isSelected) Color.White else defaultTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = item.title,
            style = TextStyle(
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Light,
                color = if (isSelected) usedTextColor else defaultTextColor
            )
        )
    }
}

@Composable
fun ChipSection(
    chip: List<String>
) {
    var selectedChipIndexState by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chip.size) {
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .padding(end = 10.dp, top = 20.dp, bottom = 10.dp)
                    .clickable { selectedChipIndexState = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectedChipIndexState == it) ButtonBlue else DarkerButtonBlue)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = chip[it], color = TextWhite,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Daily Thoughts",
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(text = "Meditation. 3-10 min", color = TextWhite, fontWeight = FontWeight.Bold)

        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .background(color = ButtonBlue),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play meditation audio",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

    }

}


/*For the featured section*/
@Composable
fun FeatureSection(features: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 10.dp
            )
    ) {
        Text(
            text = "Featured",
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                top = 10.dp,
                end = 10.dp,
                bottom = 100.dp
            ),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(10.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        /*Medium Color path*/
        val mediumColorFirstPoint = Offset(0f, height * 0.4f)
        val mediumColorSecondPoint = Offset(width * 0.1f, height * 0.45f)
        val mediumColorThirdPoint = Offset(width * 0.4f, height * 0.05f)
        val mediumColorFourthPoint = Offset(width * 0.75f, height * 0.7f)
        val mediumColorFifthPoint = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColorFirstPoint.x, mediumColorFirstPoint.y)
            standardQuadFromTo(mediumColorFirstPoint, mediumColorSecondPoint)
            standardQuadFromTo(mediumColorSecondPoint, mediumColorThirdPoint)
            standardQuadFromTo(mediumColorThirdPoint, mediumColorFourthPoint)
            standardQuadFromTo(mediumColorFourthPoint, mediumColorFifthPoint)

            /*Tough concept*/
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        /*Light Color path*/
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(path = mediumColoredPath, color = feature.mediumColor)
            drawPath(path = lightColoredPath, color = feature.lightColor)

        }

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = feature.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 10.dp, top = 10.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_headphone),
                contentDescription = "Headphone",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 10.dp)
            )

            Text(text = "Start",
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                modifier = Modifier
                    .padding(bottom = 10.dp, end = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { }
                    .background(ButtonBlue)
                    .align(Alignment.BottomEnd)
                    .width(60.dp)
                    .padding(bottom = 10.dp, start = 15.dp, top = 10.dp)
            )
        }

    }
}