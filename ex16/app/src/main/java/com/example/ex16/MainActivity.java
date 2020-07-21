package com.example.ex16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text,name;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.text);
        name=findViewById(R.id.name);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) { //수정버튼클릭시
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String strText = text.getText().toString();
                String strName = name.getText().toString();
                intent.putExtra("text",strText);
                intent.putExtra("name",strName);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1){
            text.setText(data.getStringExtra("text"));
            name.setText(data.getStringExtra("name"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}