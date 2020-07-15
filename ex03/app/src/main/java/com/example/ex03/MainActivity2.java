package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    int cnt =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn1=findViewById(R.id.btn1);
        Button btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView count=findViewById(R.id.count);
                cnt=cnt+1;
                count.setText(cnt+"");
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView count=findViewById(R.id.count);
                cnt=cnt-1;
                count.setText(cnt+"");
            }
        });

        //증가버튼 롱클릭
        btn1.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView count=findViewById(R.id.count);
                cnt=100;
                count.setText(cnt+"");
                return true;
            }
        });

        //감소버튼 롱클릭
        btn2.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView count=findViewById(R.id.count);
                cnt=0;
                count.setText(cnt+"");
                return true;
            }
        });



    }
}