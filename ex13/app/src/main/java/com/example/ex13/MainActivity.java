package com.example.ex13;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("알림");
                alert.setMessage("알림니다....");
                alert.setPositiveButton("예", null);
                alert.show();
                break;
            case R.id.btn2:
                alert= new AlertDialog.Builder(this);
                alert.setTitle("질의");
                alert.setMessage("저장하시겠습니까?");
                alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"저장",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"저장",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
                break;
            case R.id.btn3:
                final TextView text=findViewById(R.id.text);
                final String[] foods =new String[]{"짜장면", "우동", "짬뽕", "탕수육"};
                alert= new AlertDialog.Builder(this);
                alert.setTitle("음식을 선택하세요!");
                alert.setItems(foods , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(MainActivity.this,foods[i],Toast.LENGTH_SHORT).show();
                        text.setText(foods[i]);
                    }
                });
                alert.setPositiveButton("닫기",null);
                alert.show();
                break;
            case R.id.btn4:
                final LinearLayout order=(LinearLayout) v.inflate(MainActivity.this,R.layout.order,null);
                alert=new AlertDialog.Builder(this);
                alert.setTitle("주문정보");
                alert.setView(order);
                alert.setPositiveButton("주문", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name = order.findViewById(R.id.name);
                        String strName = name.getText().toString();
                        EditText num=order.findViewById(R.id.num);
                        String strNum=num.getText().toString();
                        CheckBox chk=order.findViewById(R.id.chk);
                        String strChk=chk.isChecked() ? "유" : "무";

                        Toast.makeText(MainActivity.this,
                                "상품명: "+strName+"\n"+
                                "상품수량: "+strNum+"\n"+
                                "착불결제: "+strChk,Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "주문취소",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
                break;
        }
    }
}