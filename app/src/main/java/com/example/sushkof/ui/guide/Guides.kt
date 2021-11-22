package com.example.sushkof.ui.guide

import com.example.sushkof.R

data class Guide(val image: Int, val text: String)

class Guides(val list: ArrayList<Guide> = arrayListOf(
    Guide(R.drawable.sushkof_logo, "Добро пожаловать в удобное приложение для заказа еды на дом и в ресторане"),
    Guide(R.drawable.tutorial_image_2, "Отслеживайте состояние заказа в реальном времени"),
    Guide(R.drawable.tutorial_image_3, "С помощью нашего приложения делайте заказ, находясь в ресторане")
))