package com.kc.movielist.data.repository

import android.util.Log
import com.kc.movielist.data.model.MovieItem
import com.kc.movielist.data.network.MovieFetchAPI

class MovieRepository (val movieFetchApi: MovieFetchAPI) {

    sealed class Result {
        object LOADING : Result()
        data class Success(val movieList : List<MovieItem>) :Result()
        data class Failure(val throwable: Throwable): Result()
    }
    suspend fun fetchTrendingMovies():Result{
        return try {
            val movieList = movieFetchApi.fetchTrendingMovieList().results
            Log.d("MOVIELIST","success "+movieList.size)
            Result.Success(movieList = movieList)
        }catch (exception:Exception){
            Log.d("MOVIELIST","failure ")

            Result.Failure(exception)
        }
    }

}