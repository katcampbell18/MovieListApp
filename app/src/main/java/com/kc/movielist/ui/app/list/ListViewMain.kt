package com.kc.movielist.ui.app.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.kc.movielist.data.model.MovieItem
import com.kc.movielist.ui.viewmodel.MainViewModel


class ListViewMain {

    @ExperimentalFoundationApi
    @Composable
    fun MainList(mainViewModel: MainViewModel) {
        MovieList(movieList = mainViewModel.trendingMovies)
    }
    
    @ExperimentalFoundationApi
    @Composable
    fun MovieList(
        movieList: List<MovieItem>
    ) {
        var listState = rememberLazyListState()

        LazyColumn(state = listState) {
            stickyHeader {
                MainHeader()
            }
            itemsIndexed(movieList) {index, item ->
                ListViewItem( movieItem = item)
            }
        }
    }

    @Composable
    fun MainHeader() {
        Surface(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
        Text(
            text = "Trending Movies",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
        }
    }
}