package com.example.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout page1,page2,page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        page1=findViewById(R.id.page1);
        page2=findViewById(R.id.page2);
        page3=findViewById(R.id.page3);
    }

    //버튼클릭 메서드
    public void mClick(View v){
        page1.setVisibility(View.INVISIBLE);
        page2.setVisibility(View.INVISIBLE);
        page3.setVisibility(View.INVISIBLE);
        switch (v.getId()){
            case R.id.btn1:
                page1.setVisibility(View.VISIBLE);
                break;
            case R.id.btn2:
                page2.setVisibility(View.VISIBLE);
                break;
            case R.id.btn3:
                page3.setVisibility(View.VISIBLE);
                break;
        }
    }
}