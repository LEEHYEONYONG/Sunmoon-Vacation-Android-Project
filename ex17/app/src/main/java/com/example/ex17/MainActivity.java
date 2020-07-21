package com.example.ex17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        final FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame);
        //final FragmentTransaction tr = fm.beginTransaction();

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) { //카운터 보이기
                CounterFragment cf = new CounterFragment();
                FragmentTransaction tr = fm.beginTransaction();
                tr.replace(R.id.frame,cf, "counter");
                tr.commit();
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) { //문자열 보이기
                TextFragment te = new TextFragment();
                FragmentTransaction tr = fm.beginTransaction();
                tr.replace(R.id.frame,te, "text");
                tr.commit();
            }
        });
    }
}