package com.example.test

import android.content.Context
import android.database.Cursor

class UserManager(val context:Context){

    fun addUser(user: User){
        val dataBaseHelper = DataBaseHelper(context)
        dataBaseHelper.addData(user.email,user.fName,user.lName,user.password)
    }

    fun fetchEmails(): ArrayList<String>{
        val dataBaseHelper = DataBaseHelper(context)
        var emails = ArrayList<String>()
        var data = dataBaseHelper.fetchData()
        while (data.moveToNext()){
            emails.add(data.getString(0))
        }
        return emails
    }

    fun isAvailable(email: String?):Boolean{
        val list = fetchEmails()
        for(mail in list){
            if(email == mail)return true
        }
        return false
    }

    fun fetchUser(email : String) : User{
        val dataBaseHelper = DataBaseHelper(context)
        var data = dataBaseHelper.fetchData()
        while (data.moveToNext()){
            if(data.getString(0)==email)break

        }
        return User(data.getString(1), data.getString(2),data.getString(3),data.getString(0))

    }

    fun clearUsers(){
        val dataBaseHelper = DataBaseHelper(context)
        dataBaseHelper.clearData()
    }
}