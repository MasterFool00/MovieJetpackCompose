package com.waffle.moviecomposeapp.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.waffle.moviecomposeapp.R
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.ui.theme.MovieComposeAppTheme
import com.waffle.moviecomposeapp.ui.theme.grey
import com.waffle.moviecomposeapp.ui.theme.yellow

@Composable
fun PopularItem(popular: Popular, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(16.dp)) {
        Card() {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original/${popular.posterPath}",
                contentDescription = "Movie Poster Image",
                modifier = Modifier.size(width = 80.dp, height = 120.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = popular.name ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            ChildText(text = popular.date ?: "", image = R.drawable.ic_date_range, grey)
            ChildText(text = popular.popularity.toString() , image = R.drawable.ic_person_border, grey)
            ChildText(text = popular.star.toString(), image = R.drawable.ic_star_border, yellow)
        }
    }
}

@Composable
fun ChildText(text: String, image: Int, color: Color) {
    Row(
        modifier = Modifier.padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(image),
            contentDescription = "Deskripsi Ikon",
            tint = color
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 12.sp, color = color, fontFamily = FontFamily.Monospace)
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PopularItemPreview() {
    MovieComposeAppTheme {
        Surface (
            modifier = Modifier.fillMaxWidth()
        ) {
            PopularItem(popular = Popular(1, "", "", 0.0.toFloat(), 0.0.toFloat(), "", "", "", false))
        }
    }
}