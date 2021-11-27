package com.example.sushkof.db
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Header

interface RetApi {
    @POST("user/login")
    fun getUser(@Body hashMap: HashMap<String, String>): Call<User>

    @GET("quotes")
    fun getQuotes(): Call<Quotes>
}