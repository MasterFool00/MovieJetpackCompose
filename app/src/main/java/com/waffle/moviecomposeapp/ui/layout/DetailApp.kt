package com.waffle.moviecomposeapp.ui.layout

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.ui.MovieViewModel
import com.waffle.moviecomposeapp.ui.component.PopularItem

@Composable
fun DetailApp(popular: Popular, viewModel: MovieViewModel, navigation: NavController) {
    var isFavorite by remember {
        mutableStateOf(popular.isFavorite)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original/${popular.backdropPath}",
                contentDescription = "Backdrop Image",
                modifier = Modifier
                    .height(240.dp)
                    .align(Alignment.Center)
            )
            Box(modifier = Modifier.padding(16.dp)) {
                BackButton(navigation)
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Box(modifier = Modifier.fillMaxWidth().padding(end = 16.dp, bottom = 16.dp)) {
            PopularItem(popular = popular)
            Box(
                modifier = Modifier
                    .background(Color.White, CircleShape)
                    .padding(8.dp)
                    .clickable { navigation.popBackStack() }
                    .align(Alignment.BottomEnd),
            ) {
                Icon(
                    if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    modifier = Modifier.clickable {
                        isFavorite = !isFavorite
                        popular.isFavorite = !popular.isFavorite
                        viewModel.updatePopular(popular)
                    },
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Overview", fontFamily = FontFamily.Monospace, fontSize = 16.sp,fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 16.dp))
        Text(text = popular.overview ?: "", fontFamily = FontFamily.Monospace, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), fontSize = 12.sp)
    }
}


@Composable
fun BackButton(navigation: NavController) {
    Box(
        modifier = Modifier
            .background(Color.White, CircleShape)
            .padding(8.dp)
            .clickable { navigation.popBackStack() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black
        )
    }
}