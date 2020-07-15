package com.example.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
    }

    //클릭메소드
    public void mClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                text.setTextColor(Color.WHITE);
                text.setBackgroundColor(Color.RED);
                break;
            case R.id.btn2:
                text.setTextColor(Color.RED);
                text.setBackgroundColor(Color.GREEN);                
                break;
            case R.id.btn3:
                text.setTextColor(Color.BLUE);
                text.setBackgroundColor(Color.GRAY);
                break;
        }

    }
}