package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ListView list;
    ArrayList<Address> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //데이터 생성
        data = new ArrayList<Address>();
        Address address = new Address(R.drawable.ic_launcher_background,"홍길동","010-9999-9999","경기도 화성시 화산로");
        data.add(address);
        address = new Address(R.drawable.ic_launcher_background,"강남","010-3523-5352","경기도 고양시");
        data.add(address);
        address = new Address(R.drawable.ic_launcher_background,"미러","010-4344-4345","충청남도 서천군");
        data.add(address);

        //어댑터 생성
        AddAdapter addAdapter = new AddAdapter();

        //ListView에 Adapter Set....
        list=findViewById(R.id.list);
        list.setAdapter(addAdapter);

    }


    class AddAdapter extends BaseAdapter{

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
            view =getLayoutInflater().inflate(R.layout.item_add,viewGroup,false);

            ImageView img =view.findViewById(R.id.img);
            img.setImageResource(data.get(i).img);

            TextView name =view.findViewById(R.id.name);
            name.setText(data.get(i).name);

            TextView tel =view.findViewById(R.id.tel);
            tel.setText(data.get(i).tel);

            TextView add =view.findViewById(R.id.add);
            add.setText(data.get(i).add);

            return view;
        }
    }
}