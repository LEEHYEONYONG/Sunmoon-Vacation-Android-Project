package com.example.ex12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Address> data;
    AddAdapter ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터생성
        data = new ArrayList<Address>();
        Address address = new Address("홍길동","인천 서구");
        data.add(address);
        address = new Address("홍길","인천 서");
        data.add(address);
        address = new Address("홍","인 서");
        data.add(address);

        //어댑터생성
        ad = new AddAdapter();

        //listview에 어댑터 set
        list=findViewById(R.id.list);
        list.setAdapter(ad);
    }
    //Addadapter 정의
    public class AddAdapter extends BaseAdapter{

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
        public View getView(final int i, View v, ViewGroup viewGroup) {
            v=getLayoutInflater().inflate(R.layout.item,viewGroup,false);
            final TextView name=v.findViewById(R.id.name);
            name.setText(data.get(i).name);

            TextView add=v.findViewById(R.id.add);
            add.setText(data.get(i).add);

            Button btn = v.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("질의");
                    String strName = name.getText().toString();
                    alert.setMessage(strName + "을(를) 삭제하시겠습니까?");
                    alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i1) {
                            data.remove(i);
                            ad.notifyDataSetChanged();
                        }
                    });
                    alert.setNegativeButton("아니오",null);
                    alert.show();
                }
            });
            return v;
        }
    }
}