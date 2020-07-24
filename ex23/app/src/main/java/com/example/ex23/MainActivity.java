package com.example.ex23;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Database db;
    SQLiteDatabase sql;
    Cursor cur;
    MyAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissionCheck();

        getSupportActionBar().setTitle("상품관리");

        db=new Database(this);
        sql=db.getReadableDatabase();
        cur=sql.rawQuery("select * from product",null);
        ad =new MyAdapter(this,cur);
        ListView list = findViewById(R.id.list);
        list.setAdapter(ad);
        registerForContextMenu(list);

        FloatingActionButton add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,1);
            }
        });

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


            String strFile = cursor.getString(3);
            ImageView image = view.findViewById(R.id.image);
            if(strFile.equals("") || strFile == "null"){
                image.setImageResource(R.drawable.ic_baseline_block_24);
            }else{
                Bitmap img = BitmapFactory.decodeFile(strFile);
                image.setImageBitmap(img);
            }

            final int id= cursor.getInt(0);
            ImageView delete = view.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("질의"+ id);
                    box.setMessage("삭제하실래요?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String str = "delete from product where _id="+id;
                            sql.execSQL(str);

                            cur=sql.rawQuery("select * from product",null);
                            ad.changeCursor(cur);
                        }
                    });
                    box.setNegativeButton("아니오",null);
                    box.show();
                }
            });

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("정렬방식");
        menu.add(0,1,0,"상품명정렬");
        menu.add(0,2,0,"가격정렬(높은순)");
        menu.add(0,3,0,"가격정렬(낮은순)");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                cur=sql.rawQuery("select * from product order by name",null);
                break;
            case 2:
                cur=sql.rawQuery("select * from product order by price desc",null);
                break;
            case 3:
                cur=sql.rawQuery("select * from product order by price",null);
                break;
        }
        ad.changeCursor(cur);
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK){
            cur=sql.rawQuery("select * from product",null);
            ad.changeCursor(cur);
            Toast.makeText(MainActivity.this,"등록",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"취소",Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void permissionCheck(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        }
    }
}

