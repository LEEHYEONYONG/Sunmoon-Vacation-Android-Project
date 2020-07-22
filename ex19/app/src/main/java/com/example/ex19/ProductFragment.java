package com.example.ex19;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View product = inflater.inflate(R.layout.fragment_product, container, false);

        //데이터베이스 오픈
        Database db = new Database(getContext());
        SQLiteDatabase sql = db.getReadableDatabase();

        Cursor cursor=sql.rawQuery("select * from product",null);

        //어댑터 생성
        SimpleCursorAdapter ad = new SimpleCursorAdapter(getActivity(),android.R.layout.simple_list_item_2,cursor,new String[] {"name","price"}, new int[]{android.R.id.text1,android.R.id.text2});

        
        //list <- 어댑터
        ListView list = product.findViewById(R.id.list);
        list.setAdapter(ad);

        return product;


    }
}