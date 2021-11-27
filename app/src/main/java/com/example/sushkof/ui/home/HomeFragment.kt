package com.example.sushkof.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sushkof.R
import com.example.sushkof.db.MyRetrofit
import com.example.sushkof.db.Quotes
import com.example.sushkof.db.RetApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
        val call: Call<Quotes> = retrofit.getQuotes()
        call.enqueue(object: Callback<Quotes>{
            override fun onResponse(call: Call<Quotes>, response: Response<Quotes>) {
                response.body()?.let { root.findViewById<RecyclerView>(R.id.rec_quotes).adapter = QuotesAdapter(requireContext(), it.data) }
            }

            override fun onFailure(call: Call<Quotes>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
            }

        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}