package com.example.sushkof.db
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Header

interface RetApi {
    @POST("/auth/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<Login>

    @GET("user")
    fun getUser(@Header("Authorization") token: Int): Call<ArrayList<User>>
}