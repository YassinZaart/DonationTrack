package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {


    lateinit var accountManager: AccountManager
    lateinit var fnameText : EditText
    lateinit var lnameText : EditText
    lateinit var emailText : EditText
    lateinit var passText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       accountManager = AccountManager(this)

        fnameText = findViewById(R.id.fName)
        lnameText  = findViewById(R.id.lName)
        emailText  = findViewById(R.id.email)
        passText  = findViewById(R.id.pass)
        val registerButton : Button = findViewById(R.id.register)

        registerButton.setOnClickListener { onClick() }
    }
    fun onClick(){
        var fName = fnameText.text.toString()
        var lName = lnameText.text.toString()
        var email = emailText.text.toString()
        var pass = passText.text.toString()
        var registerData = User(fName,lName,pass,email)
        var value  = accountManager.signUp(registerData)
        if(value){
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }
        else{
            val toast = Toast.makeText(this,"Email already taken",Toast.LENGTH_SHORT)
            toast.show()

        }
    }
}
