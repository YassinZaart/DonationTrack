package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fnameText : EditText = findViewById(R.id.fName)
        val lnameText : EditText = findViewById(R.id.lName)
        val emailText : EditText = findViewById(R.id.email)
        val logoutButton : Button = findViewById(R.id.logout)
        //This change is to test git workflow
        logoutButton.setOnClickListener { onClick() }
    }
    fun onClick(){
        val myIntent = Intent(this, LoginActivity::class.java)
        startActivity(myIntent)
    }
}
