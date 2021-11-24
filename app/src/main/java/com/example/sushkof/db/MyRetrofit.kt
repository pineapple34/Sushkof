package com.example.sushkof.db

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit() {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://cinema.areas.su/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}