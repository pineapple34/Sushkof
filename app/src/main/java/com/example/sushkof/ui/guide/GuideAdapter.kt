package com.example.sushkof.ui.guide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sushkof.R

class GuideAdapter(val context: Context, val guides: ArrayList<Guide>): RecyclerView.Adapter<GuideAdapter.VH>() {
    class VH(ListOfView: View): RecyclerView.ViewHolder(ListOfView){
        val img: ImageView = ListOfView.findViewById(R.id.guide_img)
        val text: TextView = ListOfView.findViewById(R.id.guide_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.guide_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Glide.with(context).load(guides[position].image).into(holder.img)
        holder.text.text = guides[position].text
    }

    override fun getItemCount(): Int {
        return guides.count()
    }
}