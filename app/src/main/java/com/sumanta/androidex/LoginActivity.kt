package com.sumanta.androidex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var signup: TextView
    private lateinit var forgotpassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btLogin)
        signup = findViewById(R.id.txtRegisterYourself)
        forgotpassword = findViewById(R.id.txtForgotPassword)

        signup.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }
        forgotpassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }


    }
}
