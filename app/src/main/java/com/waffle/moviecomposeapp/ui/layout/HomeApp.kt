@file:OptIn(ExperimentalMaterial3Api::class)

package com.waffle.moviecomposeapp.ui.layout

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.waffle.moviecomposeapp.R
import com.waffle.moviecomposeapp.base.MovieUiState
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.ui.MovieViewModel
import com.waffle.moviecomposeapp.ui.Routes
import com.waffle.moviecomposeapp.ui.component.ListPopularComponent
import com.waffle.moviecomposeapp.ui.theme.MovieComposeAppTheme

@Composable
fun HomeApp(viewModel: MovieViewModel, navigation: NavController) {
    viewModel.getPopularList()
    when (val result = viewModel.movieUiState) {
        is MovieUiState.Success -> {
            HomeMovie(list = result.movie, isLoading = false, navigation)
        }
        is MovieUiState.Loading -> {
            HomeMovie(list = listOf() , isLoading = true, navigation)
        }
        is MovieUiState.Error -> {
            HomeMovie(list = listOf(), isLoading = false, navigation)
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun HomeMovie(list: List<Popular>, isLoading: Boolean, navigation: NavController) {
    Scaffold(
        modifier = Modifier.padding(top = 24.dp),
        topBar = { HomeTopBar(navigation) }
    ) { innerPadding ->
        Box(modifier = Modifier.clickable {  }) {
            ListPopularComponent(list = list, isLoading = isLoading, innerPadding = innerPadding, navigation)
        }

    }
}

@Composable
fun HomeTopBar(navigation: NavController) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.hello_user_nwhat_movies_today),
                fontFamily = FontFamily.Monospace
            )
        },
        actions = {
            IconButton(onClick = {
                navigation.navigate(Routes.FAVORITE_SCREEN)
            }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
            }

            IconButton(onClick = {
                navigation.navigate(Routes.PROFILE_SCREEN)
            }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Account")
            }
        }
    )
}