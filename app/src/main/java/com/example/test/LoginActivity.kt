package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    lateinit var accountManager : AccountManager
    lateinit var email : EditText
    lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        accountManager = AccountManager(this)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        val loginButton : Button = findViewById(R.id.login)
        val regButton : Button = findViewById(R.id.register)
        loginButton.setOnClickListener { login() }
        regButton.setOnClickListener { register() }
    }

     fun login(){
        var value = accountManager.logIn(email.text.toString(), password.text.toString())
         var message = ""
         if(value == 1 ){
             val myIntent = Intent(this, MainActivity::class.java)
             startActivity(myIntent)
         }
         else if(value == -1) message = "Email is unavailable"
         else if(value == 0) message = "Incorrect password"

         val toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
         if(value!=1)toast.show()

     }

    fun register(){
        val myIntent = Intent(this, RegisterActivity::class.java)
        startActivity(myIntent)
    }

}
