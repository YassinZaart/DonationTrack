package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var userLocalStore :UserLocalStore
    lateinit var email : EditText
    lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userLocalStore = UserLocalStore(this)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        val loginButton : Button = findViewById(R.id.login)
        val regButton : Button = findViewById(R.id.register)
        loginButton.setOnClickListener { login() }
        regButton.setOnClickListener { register() }
    }

     fun login(){
         var user = userLocalStore.getLoggedInUSer()
        if(email.text.toString()== user?.email && password.text.toString()== user?.password)  {
            userLocalStore.setUserLoggedIn(true)
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

    }
    fun register(){
        val myIntent = Intent(this, RegisterActivity::class.java)
        startActivity(myIntent)
    }

}
