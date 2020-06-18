package com.example.test

import android.content.Context

class AccountManager(context: Context) {

    val UM = UserManager(context)
    val userLocalStore = UserLocalStore(context)


    fun logIn(email : String, password:String) : Int{
        if(!UM.isAvailable(email))return -1

        var user = UM.fetchUser(email)

        if(user.password != password)return 0

        userLocalStore.storeUserData(user)
        userLocalStore.setUserLoggedIn(true)

        return 1
    }

    fun signOut(){
        userLocalStore.clearUserData()
        userLocalStore.setUserLoggedIn(false)
    }

    fun signUp(user : User): Boolean{
        if(UM.isAvailable(user.email))return false
        UM.addUser(user)
        return true
    }

    fun isLoggedIn() : Boolean{
        return userLocalStore.isUserLoggedIn()
    }

    fun getLoggedInUser() : User{
        val user = userLocalStore.getLoggedInUSer()
        if(user == null)return User("","","","")
        else return user
    }

}