package com.example.test.webservice

import com.example.test.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("films")
    abstract fun getMovies(): Call<List<Movie>>

}