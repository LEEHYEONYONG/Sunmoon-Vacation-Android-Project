package com.example.ex20;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("create table product(_id integer primary key autoincrement, name text, price integer)");
        sql.execSQL("insert into product(name,price) values('오징어땅콩',900)");
        sql.execSQL("insert into product(name,price) values('농심포테이토칩',2000)");
        sql.execSQL("insert into product(name,price) values('로보트 태권V',1000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
