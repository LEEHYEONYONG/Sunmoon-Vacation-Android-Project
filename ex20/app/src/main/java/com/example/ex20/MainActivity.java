package com.example.ex20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Database db;
    SQLiteDatabase sql;
    Cursor cursor;
    MyAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("상품관리");


        //데이터베이스 생성
        db = new Database(this);
        sql = db.getReadableDatabase();
        cursor = sql.rawQuery("select * from product",null);


        //어댑터생성
        //SimpleCursorAdapter ad = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2, cursor , new String[]{"name","price"},new int[]{android.R.id.text1,android.R.id.text2});

        ad = new MyAdapter(this,cursor);



        //ListView <- 어댑터
        ListView list = findViewById(R.id.list);
        list.setAdapter(ad);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.add,null);
        switch (item.getItemId()){
            case R.id.add:
                AlertDialog.Builder box = new AlertDialog.Builder(this);
                box.setView(layout);
                box.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name = layout.findViewById(R.id.name);
                        String strName=name.getText().toString();
                        EditText price = layout.findViewById(R.id.price);
                        String strPrice = price.getText().toString();
                        int intPrice = Integer.parseInt(strPrice);

                        //System.out.println("상품명: " + strName);
                        //System.out.println("가격: "+ intPrice);

                        String str="insert into product(name,price) values('";
                        str+= strName + "'," + intPrice + ")";
                        sql.execSQL(str);

                        cursor=sql.rawQuery("select * from product", null);
                        ad.changeCursor(cursor);


                    }
                });
                box.setNegativeButton("취소",null);
                box.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //어댑터 정의
    public class MyAdapter extends CursorAdapter{

        public MyAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.item_main,viewGroup,false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, final Cursor c) {
            TextView name = view.findViewById(R.id.name);
            name.setText(c.getString(1));
            TextView price = view.findViewById(R.id.price);
            price.setText(c.getString(2)+"원");
            final int id = c.getInt(0);

            ImageView btn = view.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("질의:"+id);
                    box.setMessage("삭제하실래요?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String str = "delete from product where _id=" +id;
                            sql.execSQL(str);

                            cursor=sql.rawQuery("select * from product",null);
                            ad.changeCursor(cursor);
                        }
                    });
                    box.setNegativeButton("아니오",null);
                    box.show();
                }
            });

        }
    }
}