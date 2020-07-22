package com.example.ex20;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터베이스 생성
        Database db = new Database(this);
        SQLiteDatabase sql = db.getReadableDatabase();
        Cursor cursor = sql.rawQuery("select * from product",null);


        //어댑터생성
        SimpleCursorAdapter ad = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2, cursor , new String[]{"name","price"},new int[]{android.R.id.text1,android.R.id.text2});


        //ListView <- 어댑터
        ListView list = findViewById(R.id.list);
        list.setAdapter(ad);

    }
}