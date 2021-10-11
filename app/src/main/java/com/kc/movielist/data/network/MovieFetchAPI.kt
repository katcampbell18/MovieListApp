package com.kc.movielist.data.network

import com.kc.movielist.data.model.MovieResponse
import retrofit2.http.GET

interface MovieFetchAPI {

    @GET("trending/all/day?api_key={BuildConfig.API_KEY}")
    suspend fun fetchTrendingMovieList() : MovieResponse
}

