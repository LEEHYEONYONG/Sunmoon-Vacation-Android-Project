package com.example.ex11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void mClick(View v){
        switch(v.getId()){
            case R.id.btn1:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("알립니다.");
                alert.setMessage("대화상자가 열렸습니다.");
                alert.setPositiveButton("닫기",null);
                alert.show();
                break;
            case R.id.btn2:
                alert = new AlertDialog.Builder(this);
                alert.setTitle("알립니다.");
                alert.setMessage("저장하시겠습니까?");
                alert.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity5.this,"저장",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity5.this,"취소",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
                break;
        }
    }
}