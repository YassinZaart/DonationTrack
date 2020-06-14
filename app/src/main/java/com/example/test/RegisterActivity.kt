package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    lateinit var userLocalStore : UserLocalStore

    lateinit var fnameText : EditText
    lateinit var lnameText : EditText
    lateinit var emailText : EditText
    lateinit var passText : EditText
    lateinit var registerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userLocalStore = UserLocalStore(this)

         fnameText = findViewById(R.id.fName)
         lnameText  = findViewById(R.id.lName)
        emailText  = findViewById(R.id.email)
         passText  = findViewById(R.id.pass)
        registerButton = findViewById(R.id.register)

        registerButton.setOnClickListener { onClick() }
    }
    fun onClick(){
        var fName = fnameText.text.toString()
        var lName = lnameText.text.toString()
        var email = emailText.text.toString()
        var pass = passText.text.toString()
        var registerData = User(fName,lName,pass,email)
        userLocalStore.storeUserData(registerData)
        //val myIntent = Intent(this, LoginActivity::class.java)
        //startActivity(myIntent)
        registerButton.text = userLocalStore.getLoggedInUSer()?.email

    }
}
