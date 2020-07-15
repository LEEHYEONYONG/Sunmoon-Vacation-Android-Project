package com.example.ex08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=findViewById(R.id.btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sub,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
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