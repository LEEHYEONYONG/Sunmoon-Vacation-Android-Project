package com.example.ex23;

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
        sql.execSQL("create table product(_id integer primary key autoincrement, name text, price integer, image text)");
        sql.execSQL("insert into product(name,price,image) values('삼성노트북',100,'')");
        sql.execSQL("insert into product(name,price,image) values('엘지노트북',120,'')");
        sql.execSQL("insert into product(name,price,image) values('엘지드럼세탁기',220,'')");
        sql.execSQL("insert into product(name,price,image) values('삼성드럼세탁기',150,'')");
        sql.execSQL("insert into product(name,price,image) values('엘지스타일러',150,'')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
