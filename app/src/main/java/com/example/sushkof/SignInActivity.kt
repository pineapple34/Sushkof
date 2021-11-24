package com.example.sushkof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.util.Patterns
import com.example.sushkof.db.MyRetrofit
import com.example.sushkof.db.RetApi

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
            val call = retrofit.login()
        }
    }

    fun sign_upClick(view: android.view.View) {

    }
}