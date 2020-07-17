package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list, list1;
    ArrayList<String> data;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
        list1=findViewById(R.id.list1);
        spin=findViewById(R.id.spin);

        //데이터생성
        data = new ArrayList<String>();
        data.add("바나나");
        data.add("포도");
        data.add("수박");

        //어댑터생성
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,data);

        //listview에 어댑터 set
        list.setAdapter(ad);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        ArrayAdapter ad1 = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,data);
        list1.setAdapter(ad1);
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter ad2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data);
        ad2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(ad2);
    }
}