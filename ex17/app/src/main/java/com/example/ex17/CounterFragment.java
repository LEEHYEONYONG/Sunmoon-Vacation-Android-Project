package com.example.ex17;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CounterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CounterFragment extends Fragment {
    int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_counter,container,false);
        Button btn = view.findViewById(R.id.btn);
        final TextView text = view.findViewById(R.id.text);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                text.setText(count + "");
            }
        });

        return view;


    }
}