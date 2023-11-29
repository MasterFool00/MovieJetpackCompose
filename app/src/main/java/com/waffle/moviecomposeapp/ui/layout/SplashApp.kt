package com.waffle.moviecomposeapp.ui.layout

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.waffle.moviecomposeapp.R
import com.waffle.moviecomposeapp.ui.Routes
import kotlinx.coroutines.delay
import okhttp3.Route

@Composable
fun SplashApp(navigation: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000L)
        navigation.navigate(Routes.HOME_SCREEN) {
            popUpTo(Routes.SPLASH_SCREEN) { inclusive = true }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_movie),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
        )
    }

}