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
        val token = context?.getSharedPreferences("settings", Context.MODE_PRIVATE)!!.getInt("token", 0)

        val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
        val call: Call<ArrayList<User>> = retrofit.getUser(token)
        call.enqueue(object: Callback<ArrayList<User>>{
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                name.text = response.body()!![0].firstName + response.body()!![0].lastName
                email.text = response.body()!![0].email
                Glide.with(context!!).load(MyRetrofit.imgUrl + response.body()!![0].avatar).into(img)
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })

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
        context?.getSharedPreferences("settings", Context.MODE_PRIVATE)!!.edit().clear().apply()
        startActivity(Intent(context, SignInActivity::class.java))

    }
}