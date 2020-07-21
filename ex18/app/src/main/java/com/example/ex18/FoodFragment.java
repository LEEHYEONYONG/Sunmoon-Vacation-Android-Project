package com.example.ex18;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        //데이터생성
        final ArrayList<String> data = new ArrayList<String>();
        data.add("짜장면");
        data.add("짬뽕");
        data.add("탕수육");

        //어댑터생성
        ArrayAdapter ad = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,data);

        //ListView -> 어댑터
        ListView list = view.findViewById(R.id.list);
        list.setAdapter(ad);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strFood=data.get(i);
                Toast.makeText(getActivity(),strFood,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}