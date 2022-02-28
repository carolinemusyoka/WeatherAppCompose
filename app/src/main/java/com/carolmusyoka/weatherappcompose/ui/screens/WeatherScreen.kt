package com.carolmusyoka.weatherappcompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carolmusyoka.weatherappcompose.ui.components.ReusableImage
import com.carolmusyoka.weatherappcompose.R
import com.carolmusyoka.weatherappcompose.data.Weather


@Composable
fun WeatherScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        WeatherMain()
    }
}

@Composable
fun WeatherMain() {
    //check whether device theme is light
   val isLightTheme = MaterialTheme.colors.isLight
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = Weather().date,
            style = MaterialTheme.typography.h6
        )
        // Add space between Ui Components, alternative for declaring padding
        Spacer(modifier = Modifier.size(4.dp))
        //horizontal alignment of the icon and text
        Row(modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically) {
            //custom helper class
            ReusableImage(
                image = if (isLightTheme) {

                    R.drawable.ic_location_light
                } else {
                    R.drawable.ic_location_dark
                },
                contentScale = ContentScale.Fit,
                contentDesc = "Location Icon",
                modifier = Modifier
                    .size(18.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = Weather().location,
                style = MaterialTheme.typography.h6,
            )
        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .matchParentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ReusableImage(
                        image =
                        if (isLightTheme) {
                            R.drawable.ic_world_map_light
                        } else {
                            R.drawable.ic_world_map_dark
                        },
                        contentScale = ContentScale.Fit,
                        contentDesc = "Background",
                        modifier = Modifier.offset(y = (-20).dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ReusableImage(
                        image = R.drawable.ic_sun_cloud_little_rain,
                        contentScale = ContentScale.Fit,
                        contentDesc = "Weather img",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(top = 40.dp, bottom = 20.dp)
                    )
                    Text(text = Weather().condition, style = MaterialTheme.typography.subtitle1)
                    Spacer(modifier = Modifier.size(4.dp))
                    Row(modifier = Modifier.wrapContentSize()) {
                        Text(
                            text = Weather().update.first().temp,
                            style = MaterialTheme.typography.h1,
                            modifier = Modifier.offset(y = (-24).dp)
                        )
                        ReusableImage(
                            image = R.drawable.ic_degree,
                            contentScale = ContentScale.Fit,
                            contentDesc = "Degree Icon",
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = Weather().description,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.size(50.dp))
                }
            }
            DailyWeatherList()
        }

    }
}

@Composable
fun DailyWeatherList() {
    LazyRow(
        content = {
            items(Weather().update) { weather ->
                DailyWeatherItem(weather)
            }
        }
    )
}
@Composable
fun DailyWeatherItem(weatherUpdate: Weather.WeatherUpdate) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.size(height = 160.dp, width = 120.dp).padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            ReusableImage(
                image = when (weatherUpdate.icon) {
                    "wind" -> R.drawable.ic_moon_cloud_fast_wind
                    "rain" -> R.drawable.ic_moon_cloud_mid_rain
                    "angledRain" -> R.drawable.ic_sun_cloud_angled_rain
                    "thunder" -> R.drawable.ic_zaps
                    else -> R.drawable.ic_moon_cloud_fast_wind
                },
                contentScale = ContentScale.Fit,
                contentDesc = "Weather Icon",
                modifier = Modifier
                    .size(90.dp)
                    .padding(bottom = 4.dp)
            )
            Text(
                text = weatherUpdate.time,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "${weatherUpdate.temp}°",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

//@Preview
//@Composable
//fun APreview(){
//    Surface(modifier = Modifier.fillMaxSize()) {
//        WeatherMain()
//    }
//}

@Preview
@Composable
fun WeatherItems(){
    Surface(modifier = Modifier.fillMaxSize()) {
        WeatherMain()
    }
}