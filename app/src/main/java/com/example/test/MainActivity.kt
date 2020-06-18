package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var accountManager: AccountManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accountManager = AccountManager(this)

        val fnameText : TextView = findViewById(R.id.fName)
        val lnameText : TextView = findViewById(R.id.lName)
        val emailText : TextView = findViewById(R.id.email)
        val logoutButton : Button = findViewById(R.id.logout)
        logoutButton.setOnClickListener { onClick() }

        var user = accountManager.getLoggedInUser()
        fnameText.text = user.fName
        lnameText.text = user.lName
        emailText.text = user.email


    }


   override fun onStart() {
        super.onStart()
        if(!accountManager.isLoggedIn()) {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }
    }



    fun onClick(){

        accountManager.signOut()
        val myIntent = Intent(this, LoginActivity::class.java)
        startActivity(myIntent)

    }
}
