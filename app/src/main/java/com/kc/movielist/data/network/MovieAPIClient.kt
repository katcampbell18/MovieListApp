package com.kc.movielist.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MovieAPIClient {
    const val BASE_URL ="https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
    val  service:MovieFetchAPI by lazy {
        retrofit.build().
        create(MovieFetchAPI::class.java)
    }
}