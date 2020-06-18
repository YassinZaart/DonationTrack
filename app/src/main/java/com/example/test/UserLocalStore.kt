package com.example.test
import android.content.Context
class UserLocalStore(val context: Context) {

    val SP_NAME = "userDetails"
    var userLocalDatabase = context.getSharedPreferences(SP_NAME, 0)

    fun storeUserData(user : User){
        val userLocalDatabaseEditor = userLocalDatabase.edit()

        clearUserData()
        userLocalDatabaseEditor.putString("fName", user.fName)
        userLocalDatabaseEditor.putString("lName", user.lName)
        userLocalDatabaseEditor.putString("password", user.password)
        userLocalDatabaseEditor.putString("email", user.email)
        userLocalDatabaseEditor.apply()
    }

    fun setUserLoggedIn(loggedIn : Boolean){
        val userLocalDatabaseEditor = userLocalDatabase.edit()
        userLocalDatabaseEditor.putBoolean("loggedIn", loggedIn)

        userLocalDatabaseEditor.apply()
    }

    fun clearUserData(){
        val userLocalDatabaseEditor = userLocalDatabase.edit()
        userLocalDatabaseEditor.clear()

        userLocalDatabaseEditor.apply()
    }

    fun isUserLoggedIn(): Boolean{
        return (userLocalDatabase.getBoolean("loggedIn",false))

    }

    fun getLoggedInUSer(): User?{
        if (!userLocalDatabase.getBoolean("loggedIn", false)) {

            return null
        }

        val fName = userLocalDatabase.getString("fName", "")
        val lName = userLocalDatabase.getString("lName", "")
        val password = userLocalDatabase.getString("password", "")
        val email = userLocalDatabase.getString("email", "")
        return User(fName,lName,password,email)
    }
}