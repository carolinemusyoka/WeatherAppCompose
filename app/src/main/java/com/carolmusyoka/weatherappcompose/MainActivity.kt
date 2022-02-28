package com.carolmusyoka.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carolmusyoka.weatherappcompose.ui.screens.WeatherMain
import com.carolmusyoka.weatherappcompose.ui.screens.WeatherScreen
import com.carolmusyoka.weatherappcompose.ui.theme.WeatherAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {
               WeatherApp()
            }
        }
    }
}
@Composable
fun WeatherApp() {
    WeatherScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppComposeTheme {
       WeatherApp()
    }
}