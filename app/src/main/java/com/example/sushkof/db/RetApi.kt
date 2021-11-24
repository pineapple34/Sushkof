package com.example.sushkof.db
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface RetApi {
    @POST
    fun login(hashMap: HashMap<String, String>): Call<Login>
}