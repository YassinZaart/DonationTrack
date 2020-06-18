package com.example.test

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
private const val TABLE_NAME = "users_table"

class DataBaseHelper(context : Context) : SQLiteOpenHelper(context, TABLE_NAME,null,1) {

    private val TAG = "DatabaseHelper"
    private val COL1 = "email"
    private val COL2 = "fName"
    private val COL3 = "lName"
    private val COL4 = "password"

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + "(email TEXT PRIMARY KEY, " + COL2 + " TEXT," + COL3 + " TEXT,"+COL4 + " TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP IF TABLE EXISTS "+ TABLE_NAME)
        onCreate(db)
    }

    fun addData(email: String?, fName : String?, lName : String?, password : String?){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL1, email)
        values.put(COL2, fName)
        values.put(COL3, lName)
        values.put(COL4, password)

        db.insert(TABLE_NAME, null,values)


    }

    fun fetchData() : Cursor{
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val data = db.rawQuery(query,null)
        return data
    }

    fun clearData(){
        val db = this.writableDatabase
        val clearDBQuery = "DELETE FROM "+TABLE_NAME;
        db.execSQL(clearDBQuery);
    }
}

