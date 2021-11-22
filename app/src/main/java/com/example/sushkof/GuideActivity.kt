package com.example.sushkof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.sushkof.ui.guide.GuideAdapter
import com.example.sushkof.ui.guide.Guides

class GuideActivity : AppCompatActivity() {
    lateinit var pager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        pager = findViewById(R.id.guide_vp)
        pager.adapter = GuideAdapter(this, Guides().list)
    }

    fun SkipClick(view: android.view.View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}