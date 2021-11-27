package com.example.sushkof.ui.profile

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sushkof.R
import com.example.sushkof.SignInActivity
import com.example.sushkof.db.MyRetrofit
import com.example.sushkof.db.RetApi
import com.example.sushkof.db.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var email: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        img = root.findViewById(R.id.profile_img)
        name = root.findViewById(R.id.profile_name)
        email = root.findViewById(R.id.profile_email)
        val imgPath = context?.getSharedPreferences("user", Context.MODE_PRIVATE)!!.getString("avatar", null)

        name.text = context?.getSharedPreferences("user", Context.MODE_PRIVATE)!!.getString("nickName", null)
        email.text = context?.getSharedPreferences("user", Context.MODE_PRIVATE)!!.getString("email", null)
        Glide.with(requireContext()).load(imgPath).into(img)

        root.findViewById<Button>(R.id.btn_logout).setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                logOut(v!!)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun logOut(view: View){
        context?.getSharedPreferences("user", Context.MODE_PRIVATE)!!.edit().clear().apply()
        startActivity(Intent(context, SignInActivity::class.java))

    }
}