package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //클릭메소드
    public void mClick(View v){
        Intent intent=null;
        switch (v.getId()){
            case R.id.btn:
                intent=new Intent(MenuActivity.this,MainActivity.class);
                break;
            case R.id.btn1:
                intent=new Intent(MenuActivity.this,MainActivity2.class);
                break;
            case R.id.btn2:
                intent=new Intent(MenuActivity.this,MainActivity3.class);
                break;
            case R.id.btn3:
                intent=new Intent(MenuActivity.this,MainActivity4.class);
                break;
            case R.id.btn4:
                intent=new Intent(MenuActivity.this,MainActivity5.class);
                break;
        }
        startActivity(intent);
    }
}