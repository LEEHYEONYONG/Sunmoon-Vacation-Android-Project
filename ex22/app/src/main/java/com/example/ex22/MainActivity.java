package com.example.ex22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    Cursor cur;
    MyAdapter ad;
    String str= "select * from address order by name";
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("주소관리");

        db=new Database(this);
        sql=db.getReadableDatabase();
        cur=sql.rawQuery(str,null);
        ad=new MyAdapter(this,cur);
        list=findViewById(R.id.list);
        list.setAdapter(ad);

        registerForContextMenu(list);

    }


    public class MyAdapter extends CursorAdapter {

        public MyAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.item,viewGroup,false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, final Cursor cursor) {
            TextView name = view.findViewById(R.id.name);
            TextView tel = view.findViewById(R.id.tel);
            TextView address = view.findViewById(R.id.address);

            final int id = cursor.getInt(0);
            final String strName = cursor.getString(1);
            final String strTel = cursor.getString(2);
            final String strAddress = cursor.getString(3);

            name.setText(strName);
            tel.setText(strTel);
            address.setText(strAddress);

            //수정하기
            ImageView btnUpdate = view.findViewById(R.id.btnUpdate);
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View viewUpdate = getLayoutInflater().inflate(R.layout.add,null);
                    final EditText uname = viewUpdate.findViewById(R.id.name);
                    uname.setText(strName);
                    final EditText utel = viewUpdate.findViewById(R.id.tel);
                    utel.setText(strTel);
                    final EditText uaddress = viewUpdate.findViewById(R.id.address);
                    uaddress.setText(strAddress);

                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("주소수정");
                    box.setView(viewUpdate);
                    box.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String sname =uname.getText().toString();
                            String stel = utel.getText().toString();
                            String saddress = uaddress.getText().toString();
                            String str2 = "update address set name='" + sname +"', tel='"+ stel +"', address='"+ saddress +"' where _id="+id;
                            sql.execSQL(str2);
                            cur = sql.rawQuery(str,null);
                            ad.changeCursor(cur);
                        }
                    });
                    box.setNegativeButton("취소",null);
                    box.show();
                }
            });


            //전화걸기
            //final String strTel = cursor.getString(2);
            ImageView btnTel = view.findViewById(R.id.btnTel);
            btnTel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+strTel));
                    startActivity(intent);

                    /*
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+strTel));
                    startActivity(intent);
                     */
                }
            });

            //final int id=cursor.getInt(0);
            ImageView delete = view.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("질의:"+ id);
                    box.setMessage("삭제하실래요?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String str1 = "delete from address where _id=" +id;
                            sql.execSQL(str1);
                            cur = sql.rawQuery(str,null);
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

        //MenuItem search = findViewById(R.id.search);
        MenuItem search =menu.findItem(R.id.search);
        //SearchView searchView = (SearchView) search.getActionView();
        //SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                str = "select * from address where name like '%" + s + "%' or ";
                str += " tel like '%" + s + "%' or ";
                str += " address like '%" + s + "%'";
                cur = sql.rawQuery(str,null);
                ad.changeCursor(cur);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final View view = getLayoutInflater().inflate(R.layout.add,null);
        switch (item.getItemId()){
            case R.id.add:
                AlertDialog.Builder box = new AlertDialog.Builder(this);
                box.setTitle("주소입력");
                box.setView(view);
                box.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name = view.findViewById(R.id.name);
                        EditText tel = view.findViewById(R.id.tel);
                        EditText address = view.findViewById(R.id.address);

                        String strName = name.getText().toString();
                        String strTel = tel.getText().toString();
                        String strAddress = address.getText().toString();

                        String strSql="insert into address(name,tel,address) values('" + strName + "','" + strTel + "','" + strAddress + "')";
                        sql.execSQL(strSql);

                        cur = sql.rawQuery(str,null);
                        ad.changeCursor(cur);
                        Toast.makeText(MainActivity.this,"추가",Toast.LENGTH_SHORT).show();
                    }
                });
                box.setNegativeButton("취소",null);
                box.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //컨텍스트메뉴
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("정렬방식");
        menu.add(0,1,0,"이름순정렬");
        menu.add(0,2,0,"전화번호순정렬");
        menu.add(0,3,0,"주소정렬");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                str ="select * from address order by name";
                break;
            case 2:
                str ="select * from address order by tel";
                break;
            case 3:
                str ="select * from address order by address";
                break;
        }
        cur=sql.rawQuery(str,null);
        ad.changeCursor(cur);
        return super.onContextItemSelected(item);
    }
}