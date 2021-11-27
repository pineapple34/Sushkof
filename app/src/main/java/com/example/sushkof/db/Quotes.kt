package com.example.sushkof.db

data class Quotes(val success: Boolean, val data: ArrayList<Data_quotes>)
class Data_quotes(val id: Int, val title: String, val image: String, val description: String)
