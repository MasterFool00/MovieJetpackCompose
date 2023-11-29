package com.waffle.moviecomposeapp.ui.component

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.waffle.moviecomposeapp.domain.model.Popular
import com.waffle.moviecomposeapp.ui.Routes

@Composable
fun ListPopularComponent(list: List<Popular>, isLoading: Boolean, innerPadding: PaddingValues, navigation: NavController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            if (list.isNotEmpty()) {
                LazyColumn {
                    items(list) { popular ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .clickable {
                                    val json = Uri.encode(Gson().toJson(popular))
                                    Log.e("TAG", "ListPopularComponent: $json", )
                                    navigation.navigate("DetailScreen/$json")
                                }
                        ) {
                            PopularItem(popular = popular)
                        }
                    }
                }
            } else {
                Toast.makeText(context, "Empty Data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}