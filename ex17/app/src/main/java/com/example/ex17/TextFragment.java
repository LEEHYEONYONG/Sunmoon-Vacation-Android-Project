package com.example.ex17;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        Button btn =view.findViewById(R.id.btn);
        final EditText edit = view.findViewById(R.id.edit);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strEdit = edit.getText().toString();
                Toast.makeText(getContext(), strEdit, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}