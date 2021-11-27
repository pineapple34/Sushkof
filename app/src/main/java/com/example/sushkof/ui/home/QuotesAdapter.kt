package com.example.sushkof.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sushkof.R
import com.example.sushkof.db.Data_quotes

data class QuotesAdapter(val context: Context, val quotes: ArrayList<Data_quotes>): RecyclerView.Adapter<QuotesAdapter.VH>(){
    class VH(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title_text)
        val description: TextView = view.findViewById(R.id.desc_text)
        val img: ImageView = view.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.quotes_adapter, null))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.title.text = quotes[position].title
        holder.description.text = quotes[position].description
        Glide.with(context).load(quotes[position].image).into(holder.img)
    }

    override fun getItemCount(): Int {
        return quotes.count()
    }
}
