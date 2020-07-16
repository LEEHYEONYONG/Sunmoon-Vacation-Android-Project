package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    ArrayList<Item> data;
    MyAdapter ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //데이터생성
        data = new ArrayList<Item>();
        Item item = new Item(R.drawable.car1, "그랜저",1500);
        data.add(item);
        item = new Item(R.drawable.car2, "소나타",3000);
        data.add(item);
        item = new Item(R.drawable.car3, "아반테",4500);
        data.add(item);

        //어댑터생성
        ad= new MyAdapter();

        //listView에 어댑터를 끼워넣기
        ListView list = findViewById(R.id.list);
        list.setAdapter(ad);
    }

    //어댑터정의
    public class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.item1,viewGroup,false);

            ImageView img = view.findViewById(R.id.img);
            img.setImageResource(data.get(i).img);

            TextView name=view.findViewById(R.id.name);
            name.setText(data.get(i).name);
            final String strName=data.get(i).name;

            TextView price = view.findViewById(R.id.price);
            price.setText(data.get(i).price+"만원");

            Button btn = view.findViewById(R.id.btn);
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity4.this, strName + " 주문하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }

    //item 클래스
    public class Item{
        int img;
        String name;
        int price;

        public Item(int img, String name, int price) {
            this.img = img;
            this.name = name;
            this.price = price;
        }
    }
}