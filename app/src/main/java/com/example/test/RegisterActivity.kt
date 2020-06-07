package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fnameText : EditText = findViewById(R.id.fName)
        val lnameText : EditText = findViewById(R.id.lName)
        val emailText : EditText = findViewById(R.id.email)
        val passText : EditText = findViewById(R.id.pass)
        val registerButton : Button = findViewById(R.id.register)

        registerButton.setOnClickListener { onClick() }
    }
    fun onClick(){

    }
}
