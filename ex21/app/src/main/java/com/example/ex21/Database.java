package com.example.ex21;

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
        sql.execSQL("create table address(_id integer primary key autoincrement, name text, address text)");
        sql.execSQL("insert into address(name,address) values('홍길동','인천 서구 경서동')");
        sql.execSQL("insert into address(name,address) values('심청이','서울 강남구 압구정동')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
