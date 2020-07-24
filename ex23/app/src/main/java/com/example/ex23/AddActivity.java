package com.example.ex23;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    ImageView image;
    String strFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        image = findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
            }
        });
        db = new Database(this);
        sql=db.getWritableDatabase();

        getSupportActionBar().setTitle("상품등록");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder box = new AlertDialog.Builder(AddActivity.this);
                box.setTitle("질의");
                box.setMessage("저장하실래요?");
                box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name = findViewById(R.id.name);
                        EditText price = findViewById(R.id.price);
                        String strName = name.getText().toString();
                        String strPrice = price.getText().toString();
                        String str="insert into product(name,price,image) values('"+strName+"',"+strPrice+",'"+strFile+"')";
                        sql.execSQL(str);
                        setResult(RESULT_OK);
                        //Toast.makeText(AddActivity.this,"등록완료",Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });
                box.setNegativeButton("아니오",null);
                box.show();
            }
        });

        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK){
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(data.getData(),projection,null,null,null);
            cursor.moveToFirst();
            strFile = cursor.getString(cursor.getColumnIndex(projection[0]));
            cursor.close();
            //image.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData()));

            Bitmap img = BitmapFactory.decodeFile(strFile);
            image.setImageBitmap(img);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}