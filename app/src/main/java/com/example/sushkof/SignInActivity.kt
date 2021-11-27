package com.example.sushkof

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.util.Patterns
import android.widget.Toast
import com.example.sushkof.db.MyRetrofit
import com.example.sushkof.db.RetApi
import com.example.sushkof.db.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        email = findViewById(R.id.text_email)
        pass = findViewById(R.id.text_pass)
    }

    fun sign_inClick(view: android.view.View) {
        if (email.text.isNotEmpty() && pass.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches()){
            val hashMap: HashMap<String, String> = HashMap()
            hashMap["email"] = email.text.toString()
            hashMap["password"] = pass.text.toString()

            val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
            val call: Call<User> = retrofit.getUser(hashMap)
            call.enqueue(object: Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                        getSharedPreferences("user", Context.MODE_PRIVATE).edit()
                            .putString("id", response.body()?.id)
                            .putString("email", response.body()?.email)
                            .putString("nickName", response.body()?.nickName)
                            .putString("avatar", response.body()?.avatar)
                            .putString("token", response.body()?.token)
                            .apply()

                        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                        finish()
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@SignInActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
        }
    }

    fun sign_upClick(view: android.view.View) {

    }
}