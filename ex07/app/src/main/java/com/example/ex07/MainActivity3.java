package com.example.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    //버튼 클릭 메서드
    public void mClick(View v){
        switch (v.getId()){
            case R.id.btn1:
            case R.id.btn2:
                LinearLayout linear1=(LinearLayout)View.inflate(MainActivity3.this,R.layout.custom1,null);
                Toast toast1= new Toast(MainActivity3.this);
                toast1.setView(linear1);
                toast1.show();
                break;
            case R.id.btn3:
                count++;//count= count+1;
                Toast.makeText(MainActivity3.this,"현재카운트:"+count,Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                LinearLayout linear=(LinearLayout)View.inflate(MainActivity3.this,R.layout.custom,null);
                Toast toast= new Toast(MainActivity3.this);
                toast.setView(linear);
                toast.show();
        }
    }
}