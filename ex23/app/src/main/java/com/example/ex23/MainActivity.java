package com.example.ex23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Database db;
    SQLiteDatabase sql;
    Cursor cur;
    MyAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("상품관리");

        db=new Database(this);
        sql=db.getReadableDatabase();
        cur=sql.rawQuery("select * from product",null);
        ad =new MyAdapter(this,cur);
        ListView list = findViewById(R.id.list);
        list.setAdapter(ad);
    }

    //어댑터정의
    class MyAdapter extends CursorAdapter{

        public MyAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.item,null);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView name= view.findViewById(R.id.name);
            name.setText(cursor.getString(1));
            TextView price= view.findViewById(R.id.price);
            price.setText(cursor.getString(2)+"만원");

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String str = "select * from product where name like '%" + s + "%'";
                cur=sql.rawQuery(str,null);
                ad.changeCursor(cur);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}