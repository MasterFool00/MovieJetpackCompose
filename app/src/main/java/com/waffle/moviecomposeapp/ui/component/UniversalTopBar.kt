package com.waffle.moviecomposeapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController

@Composable
fun UniversalTopBar(name: String, navigation: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(modifier = Modifier.align(Alignment.CenterStart), onClick = {
            navigation.popBackStack()
        }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button")
        }
        Text(text = name, fontFamily = FontFamily.Monospace)
    }
}