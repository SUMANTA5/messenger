package com.sumanta.androidex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignupActivity : AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        toolbar = findViewById(R.id.toolbar)
        toolbar()
    }
    fun toolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "SineUp"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
