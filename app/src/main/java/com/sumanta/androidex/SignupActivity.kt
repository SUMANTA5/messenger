package com.sumanta.androidex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        toolbar = findViewById(R.id.toolbar)
        toolbar()

        auth = FirebaseAuth.getInstance()


        btSingup.setOnClickListener {
            siqnUpuser()

        }
    }
    private fun toolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "SineUp"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun siqnUpuser(){

      /*  if (etLastName.text.toString().isEmpty()){
            etFastName.error ="Please enter last name"
            etFastName.requestFocus()
            return
        }*/
        if (etEmailSinup.text.toString().isEmpty()){
            etEmailSinup.error ="Please enter email"
            etEmailSinup.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(etEmailSinup.text.toString()).matches()){
            etEmailSinup.error ="Please enter valid email"
            etEmailSinup.requestFocus()
            return
        }
        if (etPasswordSinpu.text.toString().isEmpty()){
            etPasswordSinpu.error ="Please enter password"
            etPasswordSinpu.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(etEmailSinup.text.toString(), etPasswordSinpu.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this@SignupActivity, DashboardActivity::class.java))
                    finish()
                } else {

                    Toast.makeText(baseContext, "Sing up failed.",
                        Toast.LENGTH_SHORT).show()

                }

            }
    }

}
