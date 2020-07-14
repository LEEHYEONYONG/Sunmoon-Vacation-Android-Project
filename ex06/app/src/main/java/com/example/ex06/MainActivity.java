package com.example.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.image);
        findViewById(R.id.btn1).setOnLongClickListener(mLong);
        findViewById(R.id.btn2).setOnLongClickListener(mLong);
        findViewById(R.id.btn3).setOnLongClickListener(mLong);
        findViewById(R.id.btn4).setOnLongClickListener(mLong);
        findViewById(R.id.btn5).setOnLongClickListener(mLong);
    }


    //롱클릭메서드
    Button.OnLongClickListener mLong = new View.OnLongClickListener() {
        String str;

        @Override
        public boolean onLongClick(View view) {
            switch (view.getId()){
                case R.id.btn1:
                    str="1번째 이미지입니다.";
                    break;
                case R.id.btn2:
                    str="2번째 이미지입니다.";
                    break;
                case R.id.btn3:
                    str="3번째 이미지입니다.";
                    break;
                case R.id.btn4:
                    str="4번째 이미지입니다.";
                    break;
                case R.id.btn5:
                    str="5번째 이미지입니다.";
                    break;

            }
            Toast.makeText(MainActivity.this,str, Toast.LENGTH_SHORT).show();
            return false;
        }
    };

    //클릭이벤트
    public void mClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                image.setImageResource(R.drawable.car1);
                break;
            case R.id.btn2:
                image.setImageResource(R.drawable.car2);
                break;
            case R.id.btn3:
                image.setImageResource(R.drawable.car3);
                break;
            case R.id.btn4:
                image.setImageResource(R.drawable.car4);
                break;
            case R.id.btn5:
                image.setImageResource(R.drawable.car5);
                break;

        }
    }
}