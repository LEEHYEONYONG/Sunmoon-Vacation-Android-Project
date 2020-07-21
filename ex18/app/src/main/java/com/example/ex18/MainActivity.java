package com.example.ex18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fm = getSupportFragmentManager();
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {//음식목록출력
                FoodFragment food = new FoodFragment();
                FragmentTransaction tr =fm.beginTransaction();
                tr.replace(R.id.frame,food, "food");
                tr.commit();
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                FruitFragment fruit = new FruitFragment();
                FragmentTransaction tr=fm.beginTransaction();
                tr.replace(R.id.frame,fruit,"fruit");
                tr.commit();
            }
        });
    }
}