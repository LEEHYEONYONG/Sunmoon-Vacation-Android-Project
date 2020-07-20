package com.example.ex15;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name,add,age,tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        add=findViewById(R.id.add);
        age=findViewById(R.id.age);
        tel=findViewById(R.id.tel);

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //startActivity(intent);

                String strName = name.getText().toString();
                String strAdd = add.getText().toString();
                String strAge = age.getText().toString();
                int intAge = Integer.parseInt(strAge);
                String strTel = tel.getText().toString();

                intent.putExtra("name",strName);
                intent.putExtra("add",strAdd);
                intent.putExtra("age",intAge);
                intent.putExtra("tel",strTel);
                startActivityForResult(intent,0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==1) {
            name.setText(data.getStringExtra("name"));
            add.setText(data.getStringExtra("add"));
            age.setText(data.getStringExtra("age"));
            tel.setText(data.getStringExtra("tel"));
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}