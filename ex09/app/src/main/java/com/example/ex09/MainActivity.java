package com.example.ex09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);
        registerForContextMenu(btn);
        registerForContextMenu(btn1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v==btn){
            menu.setHeaderTitle("크기변경");
            menu.add(0,1,0,"50px");
            menu.add(0,2,0,"100px");
            menu.add(0,3,0,"150px");
        }
        if(v==btn1){
            menu.setHeaderTitle("색상변경");
            menu.add(0,4,0,"black");
            menu.add(0,5,0,"red");
            menu.add(0,6,0,"blue");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.size1:
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
                break;
            case R.id.size2:
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                break;
            case R.id.size3:
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,150);
                break;
            case R.id.color1:
                btn.setTextColor(Color.BLACK);
                break;
            case R.id.color2:
                btn.setTextColor(Color.RED);
                break;
            case R.id.color3:
                btn.setTextColor(Color.BLUE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        int size=(int)btn.getTextSize();
        switch (size){
            case 50:
                menu.findItem(R.id.size1).setChecked(true);
                break;
            case 100:
                menu.findItem(R.id.size2).setChecked(true);
                break;
            case 150:
                menu.findItem(R.id.size3).setChecked(true);
                break;
        }
        int color= btn.getTextColors().getDefaultColor();
        switch (color){
            case Color.RED:
                menu.findItem(R.id.color2).setChecked(true);
                break;
            case Color.BLACK:
                menu.findItem(R.id.color1).setChecked(true);
                break;
            case Color.BLUE:
                menu.findItem(R.id.color3).setChecked(true);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
                break;
            case 2:
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                break;
            case 3:
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,150);
                break;
            case 4:
                btn1.setTextColor(Color.BLACK);
                break;
            case 5:
                btn1.setTextColor(Color.RED);
                break;
            case 6:
                btn1.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}