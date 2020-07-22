package com.example.ex19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table product(_id integer primary key autoincrement, name text, price integer);");
        db.execSQL("insert into product(name,price) values('오징어땅콩',900)");
        db.execSQL("insert into product(name,price) values('농심 포테이토 칩',2000)");
        db.execSQL("insert into product(name,price) values('88 라이트',1900)");
        db.execSQL("insert into product(name,price) values('오레오',1200)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
