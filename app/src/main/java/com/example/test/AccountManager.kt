package com.example.test

import android.content.Context

class AccountManager(context: Context) {

    val UM = UserManager(context)
    val user = User("","","","")
    var loggedIn = false

    fun logIn(email : String, password:String) : Int{
        if(!UM.isAvailable(email))return -1

        var user = UM.fetchUser(email)

        if(user.password != password)return 0
        loggedIn = true
        this.user.fName = user.fName
        this.user.lName = user.lName
        this.user.password = user.password
        this.user.email = user.email
        return 1
    }

    fun signOut(){
        user.fName = ""
        user.lName = ""
        user.password = ""
        user.email = ""
        loggedIn = false
    }

    fun signUp(user : User): Boolean{
        if(UM.isAvailable(user.email))return false
        UM.addUser(user)
        return true
    }

}