package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username : EditText = findViewById(R.id.username)
        val password : EditText = findViewById(R.id.password)
        val loginButton : Button = findViewById(R.id.login)
        val regButton : Button = findViewById(R.id.register)
        loginButton.setOnClickListener { login() }
        regButton.setOnClickListener { register() }
    }

     fun login(){

    }
    fun register(){
        val myIntent = Intent(this, RegisterActivity::class.java)
        startActivity(myIntent)
    }

}
