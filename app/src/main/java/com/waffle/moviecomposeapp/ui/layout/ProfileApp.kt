package com.waffle.moviecomposeapp.ui.layout

import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.waffle.moviecomposeapp.R
import com.waffle.moviecomposeapp.ui.component.UniversalTopBar

@Composable
fun ProfileApp(navigation: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .padding(top = 24.dp)
            .align(Alignment.TopCenter)
            .fillMaxWidth()) {
            UniversalTopBar(name = "Profile", navigation = navigation)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.my_image), contentScale = ContentScale.Crop, contentDescription = "profile image", modifier = Modifier.clip(
                CircleShape).size(80.dp))
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Enrico Olivian Maricar", fontFamily = FontFamily.Monospace, fontSize = 16.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "enrico.maricar@gmail.com", fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
    }
}