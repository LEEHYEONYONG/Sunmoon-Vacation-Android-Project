package com.example.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout page1,page2,page3;
    EditText text1;
    ImageView image;
    //TextView sum;
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        page1=findViewById(R.id.page1);
        page2=findViewById(R.id.page2);
        page3=findViewById(R.id.page3);
        text1=findViewById(R.id.text1);
        image=findViewById(R.id.image);

    }

    //버튼클릭 메서드
    public void mClick(View v){
        page1.setVisibility(View.INVISIBLE);
        page2.setVisibility(View.INVISIBLE);
        page3.setVisibility(View.INVISIBLE);
        switch (v.getId()){
            case R.id.btn1:
                page1.setVisibility(View.VISIBLE);
                break;
            case R.id.btn2:
                page2.setVisibility(View.VISIBLE);
                break;
            case R.id.btn3:
                page3.setVisibility(View.VISIBLE);
                break;
            case R.id.btn4:
                page1.setVisibility(View.VISIBLE);
                str=text1.getText().toString();
                Toast.makeText(MainActivity2.this,str,Toast.LENGTH_SHORT).show();
                break;
            case R.id.imagebtn1:
                page2.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.car1);
                break;
            case R.id.imagebtn2:
                page2.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.car2);
                break;
            case R.id.imagebtn3:
                page2.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.car3);
                break;
            case R.id.btnSum:
                page3.setVisibility(View.VISIBLE);
                int sum=0;
                for(int i=0;i<=100;i++){
                    sum=sum+i;
                }
                Toast.makeText(MainActivity2.this,sum+"",Toast.LENGTH_SHORT).show();
                TextView txtsum=findViewById(R.id.sum);
                txtsum.setText("합계="+sum);
                break;
        }
    }
}