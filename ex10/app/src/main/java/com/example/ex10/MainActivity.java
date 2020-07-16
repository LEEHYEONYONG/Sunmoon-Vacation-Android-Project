package com.example.ex10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image1,image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        registerForContextMenu(image1);
        registerForContextMenu(image2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v==image1){
            menu.setHeaderTitle("현대자동차");
            menu.add(0,1,0,"그랜저");
            menu.add(0,2,0,"소나타");
            menu.add(0,3,0,"제네시스");
        }
        if(v==image2){
            menu.setHeaderTitle("기아자동차");
            menu.add(0,4,0,"K7");
            menu.add(0,5,0,"K5");
            menu.add(0,6,0,"카니발");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                image1.setImageResource(R.drawable.car1);
                break;
            case 2:
                image1.setImageResource(R.drawable.car2);
                break;
            case 3:
                image1.setImageResource(R.drawable.car3);
                break;
            case 4:
                image2.setImageResource(R.drawable.car4);
                break;
            case 5:
                image2.setImageResource(R.drawable.car5);
                break;
            case 6:
                image2.setImageResource(R.drawable.car6);
                break;
        }
        return super.onContextItemSelected(item);
    }
}