package com.kc.movielist.ui.app.list


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.kc.movielist.data.model.MovieItem
import com.kc.movielist.utils.Constants

class ListViewItem {

    @Composable
    fun ListViewItem(
        movieItem: MovieItem, modifier: Modifier
    ) {
        Card(modifier = modifier) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                MovieImagebanner(imagePath = movieItem.backdrop_path)
                MovieMetaDataItem(movieItem = movieItem)
            }
        }
    }

    @Composable
    fun MovieImagebanner(imagePath: String) {
        Image(
            modifier = Modifier
                .width(180.dp)
                .height(100.dp), painter = rememberCoilPainter(
                request = Constants.BASE_IMAGE_URL + imagePath
            ),
            contentDescription = ""
        )
    }

    @Composable
    fun MovieMetaDataItem(movieItem: MovieItem) {
        Column(
            modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp)
        ) {
            movieItem?.title?.let {
                Text(
                    text = it
                )
                Text(
                    text = movieItem.vote_average,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}