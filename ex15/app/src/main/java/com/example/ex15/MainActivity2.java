package com.example.ex15;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText name,add,age,tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.name);
        add=findViewById(R.id.add);
        age=findViewById(R.id.age);
        tel=findViewById(R.id.tel);

        Intent intent = getIntent();
        String strName = intent.getStringExtra("name");
        String strAdd = intent.getStringExtra("add");
        int intAge = intent.getIntExtra("age",0);
        String strTel = intent.getStringExtra("tel");

        name.setText(strName);
        add.setText(strAdd);
        age.setText(intAge+"");
        tel.setText(strTel);

        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {//저장버튼
            @Override
            public void onClick(View view) {
                String strName=name.getText().toString();
                String strAdd=add.getText().toString();
                String strAge=age.getText().toString();
                String strTel=tel.getText().toString();


                Intent intent = new Intent();
                intent.putExtra("name",strName);
                intent.putExtra("add",strAdd);
                intent.putExtra("age",strAge);
                intent.putExtra("tel",strTel);
                setResult(1,intent);
                finish();
            }
        });

        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new Button.OnClickListener() {//취소버튼
            @Override
            public void onClick(View view) {
                setResult(0);
                finish();
            }
        });


    }


}