package com.example.ex08;

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

public class MainActivity2 extends AppCompatActivity {
    Button btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);

        registerForContextMenu(btn);
        registerForContextMenu(btn1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v==btn) {
            menu.setHeaderTitle("글자색변경");
            menu.add(0, 1, 0, "빨강");
            menu.add(0, 2, 0, "파랑");
            menu.add(0, 3, 0, "초록");
        }
        if(v==btn1){
            menu.setHeaderTitle("배경색변경");
            menu.add(0, 4, 0, "빨강");
            menu.add(0, 5, 0, "파랑");
            menu.add(0, 6, 0, "초록");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                btn.setTextColor(Color.RED);
                break;
            case 2:
                btn.setTextColor(Color.BLUE);
                break;
            case 3:
                btn.setTextColor(Color.GREEN);
                break;
            case 4:
                btn1.setBackgroundColor(Color.RED);
                break;
            case 5:
                btn1.setBackgroundColor(Color.BLUE);
                break;
            case 6:
                btn1.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sub,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(btn.getTextSize()==200){
            menu.findItem(R.id.bigfont).setChecked(true);
        }else{
            menu.findItem(R.id.bigfont).setChecked(false);
        }

        int color=btn.getTextColors().getDefaultColor();
        switch (color){
            case Color.RED:
                menu.findItem(R.id.red).setChecked(true);
                break;
            case Color.BLUE:
                menu.findItem(R.id.blue).setChecked(true);
                break;
            case Color.GREEN:
                menu.findItem(R.id.green).setChecked(true);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.bigfont:
                if(item.isChecked()){
                    btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                }else{
                    btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,200);
                }
            case R.id.red:
                //btn.setBackgroundColor(Color.RED);
                btn.setTextColor(Color.RED);
                break;
            case R.id.blue:
                //btn.setBackgroundColor(Color.BLUE);
                btn.setTextColor(Color.BLUE);
                break;
            case R.id.green:
                //btn.setBackgroundColor(Color.GREEN);
                btn.setTextColor(Color.GREEN);
        }
        return super.onOptionsItemSelected(item);
    }
}