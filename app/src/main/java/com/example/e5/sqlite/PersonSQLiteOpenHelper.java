package com.example.e5.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by E5 on 2016/7/13.
 */
public class PersonSQLiteOpenHelper extends SQLiteOpenHelper{

    PersonSQLiteOpenHelper(Context context){
        super(context,"F", null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table F(id integer primary key autoincrement,name varchar(20), number varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table F add account varchar(20)");
    }
}
