package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        //데이터생성
        //어댑터생성
        final ArrayAdapter ad =ArrayAdapter.createFromResource(this,R.array.fruits,android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //spinner->Adapter
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(ad);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity5.this, ad.getItem(i).toString(),0).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final ArrayAdapter ad1=ArrayAdapter.createFromResource(this,R.array.chinese,android.R.layout.simple_spinner_item);
        ad1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        Spinner spinner1 = findViewById(R.id.spinner1);
        spinner1.setAdapter(ad1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity5.this, ad1.getItem(i).toString(),0).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //데이터생성
        ArrayList<String> data = new ArrayList<String>();
        data.add("으갹");
        data.add("무다");
        //어댑터생성
        ArrayAdapter ad2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data);
        ad2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        //adapter->spinner
        Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(ad2);





    }
}