package com.waffle.moviecomposeapp.ui

import android.os.Bundle
import android.util.Log
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.ui.layout.DetailApp
import com.waffle.moviecomposeapp.ui.layout.FavoriteApp
import com.waffle.moviecomposeapp.ui.layout.HomeApp
import com.waffle.moviecomposeapp.ui.layout.ProfileApp
import com.waffle.moviecomposeapp.ui.layout.SplashApp
import com.waffle.moviecomposeapp.ui.theme.MovieComposeAppTheme
import com.waffle.moviecomposeapp.utils.AssetParamType
import org.koin.android.ext.android.inject

class MovieApp : ComponentActivity() {

    private val viewModel: MovieViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Navigation(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Navigation(viewModel: MovieViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH_SCREEN) {
        composable(Routes.SPLASH_SCREEN) {
            SplashApp(navigation = navController)
        }
        composable(Routes.HOME_SCREEN) {
            HomeApp(viewModel, navController)
        }
        composable(Routes.FAVORITE_SCREEN) {
            FavoriteApp(viewModel, navController)
        }
        composable(Routes.DETAIL_SCREEN,
            arguments = listOf(
            navArgument(Routes.Values.DETAIL_SCREEN_VALUE) {
                type = AssetParamType()
            })) {
            val popular = it.arguments?.getParcelable<Popular>(Routes.Values.DETAIL_SCREEN_VALUE) ?: Popular(1, "", "", 0.0.toFloat(), 0.0.toFloat(), "", "", "", false)
            Log.e("TAG", "Navigation1: $popular", )
            DetailApp(popular, viewModel, navController)
        }
        composable(Routes.PROFILE_SCREEN) {
            ProfileApp(navController)
        }

    }
}