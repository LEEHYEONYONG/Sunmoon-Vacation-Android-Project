package com.example.ex14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    EditText edit;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        intent = getIntent();
        String strText=intent.getStringExtra("text");

        edit = findViewById(R.id.edit);
        edit.setText(strText);
    }

    public void mClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                String strEdit=edit.getText().toString();
                intent.putExtra("text",strEdit);
                //startActivity(intent);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.btn2:
                setResult(RESULT_CANCELED,intent);
                finish();
                break;
        }
    }
}