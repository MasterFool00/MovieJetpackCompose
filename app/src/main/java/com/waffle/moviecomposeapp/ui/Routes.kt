package com.waffle.moviecomposeapp.ui

import com.waffle.moviecomposeapp.domain.model.Popular

object Routes {
    const val SPLASH_SCREEN = "SplashScreen"
    const val HOME_SCREEN = "HomeScreen"
    const val FAVORITE_SCREEN = "FavoriteScreen"
    const val DETAIL_SCREEN = "DetailScreen/{${Values.DETAIL_SCREEN_VALUE}}"
    const val PROFILE_SCREEN = "ProfileScreen"

    object Values {
        const val DETAIL_SCREEN_VALUE = "detailValue"
    }
}