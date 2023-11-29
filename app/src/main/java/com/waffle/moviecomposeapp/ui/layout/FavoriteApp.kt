@file:OptIn(ExperimentalMaterial3Api::class)

package com.waffle.moviecomposeapp.ui.layout

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.waffle.moviecomposeapp.base.MovieUiState
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.ui.MovieViewModel
import com.waffle.moviecomposeapp.ui.component.ListPopularComponent
import com.waffle.moviecomposeapp.ui.component.UniversalTopBar
import com.waffle.moviecomposeapp.ui.theme.MovieComposeAppTheme


@Composable
fun FavoriteApp(viewModel: MovieViewModel, navigation: NavController) {
    viewModel.getPopularFavorite()
    when (val result = viewModel.favoriteUiState) {
        is MovieUiState.Success -> {
            FavoriteMovie(list = result.movie, isLoading = false, navigation)
        }
        is MovieUiState.Loading -> {
            FavoriteMovie(list = listOf() , isLoading = true, navigation)
        }
        is MovieUiState.Error -> {
            FavoriteMovie(list = listOf(), isLoading = false, navigation)
        }
    }
}

@Composable
fun FavoriteMovie(list: List<Popular>, isLoading: Boolean, navigation: NavController) {
    Scaffold(
        modifier = Modifier.padding(top = 24.dp),
        topBar = { UniversalTopBar(name = "Favorite", navigation = navigation) }
    ) { innerPadding ->
        ListPopularComponent(list = list, isLoading = isLoading, innerPadding = innerPadding, navigation)
    }
}
