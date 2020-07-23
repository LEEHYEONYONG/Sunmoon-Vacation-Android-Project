package com.example.ex21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    Cursor cur;
    MyAdapter ad;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new Database(this);
        sql=db.getReadableDatabase();
        cur=sql.rawQuery("select * from address order by name",null);
        ad=new MyAdapter(this,cur);
        list=findViewById(R.id.list);
        list.setAdapter(ad);


        Button add = findViewById(R.id.add);
        add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.add,null);
                AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                box.setTitle("주소입력");
                box.setView(layout);
                box.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText name = layout.findViewById(R.id.name);
                        EditText address = layout.findViewById(R.id.address);
                        String strName = name.getText().toString();
                        String strAddress = address.getText().toString();

                        String str = "insert into address(name,address) values(";
                        str += "'" + strName + "',";
                        str += "'" + strAddress + "')";

                        sql.execSQL(str);
                        cur = sql.rawQuery("select * from address",null);
                        ad.changeCursor(cur);
                    }
                });
                box.setNegativeButton("취소",null);
                box.show();
            }
        });
    }


    //어댑터 클래스
    public class MyAdapter extends CursorAdapter{

        public MyAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.item,viewGroup,false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView name = view.findViewById(R.id.name);
            TextView address = view.findViewById(R.id.address);
            name.setText(cursor.getString(1));
            address.setText(cursor.getString(2));
            final int id = cursor.getInt(0);

            Button btn = view.findViewById(R.id.btn);
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("삭제 " + id);
                    box.setMessage("삭제하실래요?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String str = "delete from address where _id="+id;
                            sql.execSQL(str);
                            cur=sql.rawQuery("select * from address",null);
                            ad.changeCursor(cur);
                        }
                    });
                    box.setNegativeButton("아니오",null);
                    box.show();
                }
            });

        }
    }
}