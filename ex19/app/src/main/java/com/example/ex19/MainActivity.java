package com.example.ex19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("액션바");
        getSupportActionBar().setSubtitle("서브타이틀");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//뒤로가기
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_attach_money_24);//로고

        final FragmentManager fm = getSupportFragmentManager();

        RadioButton btn1 =findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {//상품목록
                FragmentTransaction tr = fm.beginTransaction();
                ProductFragment product = new ProductFragment();
                tr.replace(R.id.frame,product,"product");
                tr.commit();
            }
        });

        RadioButton btn2 =findViewById(R.id.btn2);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {//주소목록
                FragmentTransaction tr = fm.beginTransaction();
                AddressFragment address = new AddressFragment();
                tr.replace(R.id.frame,address,"address");
                tr.commit();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.one:
                Toast.makeText(MainActivity.this,"One",Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(MainActivity.this,"Two",Toast.LENGTH_SHORT).show();
                break;
            case R.id.three:
                Toast.makeText(MainActivity.this,"Three",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}