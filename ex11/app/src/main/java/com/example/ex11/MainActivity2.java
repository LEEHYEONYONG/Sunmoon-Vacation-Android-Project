package com.example.ex11;

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

public class MainActivity2 extends AppCompatActivity {
    ListView list;
    ArrayList<Product> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        data= new ArrayList<Product>();
        Product product = new Product(R.drawable.car1, "제네시스",9000);
        data.add(product);
        product= new Product(R.drawable.car2, "소나타",5000);
        data.add(product);
        product= new Product(R.drawable.car2, "아반테",3000);
        data.add(product);

        //어댑터 생성
        MyAdapter ad = new MyAdapter();

        //ListView에 어댑터를 Set
        list=findViewById(R.id.list);
        list.setAdapter(ad);
    }

    //MyAdapter 정의
    class MyAdapter extends BaseAdapter{

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
            view=getLayoutInflater().inflate(R.layout.item,viewGroup,false);

            ImageView img=view.findViewById(R.id.img);
            img.setImageResource(data.get(i).img);

            final TextView name = view.findViewById(R.id.name);
            name.setText(data.get(i).name);

            TextView price = view.findViewById(R.id.price);
            price.setText(data.get(i).price+"만원");

            Button btn=view.findViewById(R.id.btn);
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity2.this , name.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }
}