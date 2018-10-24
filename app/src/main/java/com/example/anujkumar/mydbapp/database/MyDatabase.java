package com.example.anujkumar.mydbapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.anujkumar.mydbapp.helper.MyHelper;

public class MyDatabase {
    //Create a Database
    public static final String MY_DB="employeeDB";

    Context myCon;
    SQLiteDatabase sdb;
    MyHelper myHelper;

    public MyDatabase(Context myContext) {
        myCon = myContext;
        myHelper = new MyHelper(myCon,MY_DB,null,1);
    }
    //method to open database
    public void open(){
        sdb=myHelper.getWritableDatabase();
    }
    //method to insert the values
    public void insertEmp(ContentValues cv){
        //query to inset the value into the DB

        sdb.insert("employee",null,cv);
        Log.i("EmployeeDB","Data Inserted");
    }
    public Cursor getEmp(){
        sdb=myHelper.getReadableDatabase();
        Cursor cursor=sdb.query("employee",null,null,null,null,null,null);
        return cursor;
    }
}
