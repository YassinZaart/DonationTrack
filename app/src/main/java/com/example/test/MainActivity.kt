package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var userLocalStore : UserLocalStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userLocalStore = UserLocalStore(this)

        val fnameText : TextView = findViewById(R.id.fName)
        val lnameText : TextView = findViewById(R.id.lName)
        val emailText : TextView = findViewById(R.id.email)
        val logoutButton : Button = findViewById(R.id.logout)
        logoutButton.setOnClickListener { onClick() }

        var user = userLocalStore.getLoggedInUSer()
        fnameText.text= user?.fName
        lnameText.text=user?.lName
        emailText.text=user?.email
    }

    //Changes to login Screen if the user is not Logged in
    override fun onStart() {
        super.onStart()
        if(!userLocalStore.getUserLoggedIn()){
        val myIntent = Intent(this, LoginActivity::class.java)
        startActivity(myIntent)
        }
    }



    fun onClick(){
        userLocalStore.clearUserData()
        userLocalStore.setUserLoggedIn(false)
        val myIntent = Intent(this, LoginActivity::class.java)
        startActivity(myIntent)

    }
}
