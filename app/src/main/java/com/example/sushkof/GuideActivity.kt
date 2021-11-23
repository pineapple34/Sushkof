package com.example.sushkof

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.sushkof.ui.guide.GuideAdapter
import com.example.sushkof.ui.guide.Guides
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GuideActivity : AppCompatActivity() {
    lateinit var pager: ViewPager2
    lateinit var tab: TabLayout
    lateinit var btn_next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        tab = findViewById(R.id.tab)
        pager = findViewById(R.id.guide_vp)
        pager.adapter = GuideAdapter(this, Guides().list)
        TabLayoutMediator(tab, pager){_,_->}.attach()

        btn_next = findViewById(R.id.button_next)
        btn_next.setOnClickListener {
            if (pager.currentItem != 2) pager.currentItem += 1
            else SkipClick(btn_next)
        }
    }

    fun SkipClick(view: android.view.View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}