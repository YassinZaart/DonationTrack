package com.example.test

import android.content.Context


class UserLocalStore(val context: Context) {

    val SP_NAME = "userDetails"
    var userLocalDatabase = context.getSharedPreferences(SP_NAME, 0)

    fun storeUserData(user : User){
        val userLocalDatabaseEditor = userLocalDatabase.edit()
        userLocalDatabaseEditor.putString("fname", user.fName)
        userLocalDatabaseEditor.putString("lName", user.lName)
        userLocalDatabaseEditor.putString("password", user.password)
        userLocalDatabaseEditor.putString("email", user.email)
        userLocalDatabaseEditor.commit()
    }

    fun setUserLoggedIn(loggedIn : Boolean){
        val userLocalDatabaseEditor = userLocalDatabase.edit()
        userLocalDatabaseEditor.putBoolean("loggedIn", loggedIn)
        userLocalDatabaseEditor.commit()
    }

    fun clearUserData(){
        val userLocalDatabaseEditor = userLocalDatabase.edit()
        userLocalDatabaseEditor.clear()
        userLocalDatabaseEditor.commit()
    }

    fun getLoggedInUSer(): User?{
        if (!userLocalDatabase.getBoolean("loggedIn", false)) {
            return null;
        }

        var fName = userLocalDatabase.getString("fname", "")
        var lName = userLocalDatabase.getString("lName", "")
        var password = userLocalDatabase.getString("password", "")
        var email = userLocalDatabase.getString("email", "")

        return User(fName,lName,password,email)
    }
}