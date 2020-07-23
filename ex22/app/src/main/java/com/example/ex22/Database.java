package com.example.ex22;

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
        sql.execSQL("create table address(_id integer primary key autoincrement,name text,tel text,address text)");
        sql.execSQL("insert into address(name,tel,address) values('홀길동','010-0001-0001','인천시 서구')");
        sql.execSQL("insert into address(name,tel,address) values('아아아','010-0111-1111','안드로메다')");
        sql.execSQL("insert into address(name,tel,address) values('이현용','010-9954-4256','안드로메다')");
        sql.execSQL("insert into address(name,tel,address) values('마마마','010-2352-3434','목성')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
