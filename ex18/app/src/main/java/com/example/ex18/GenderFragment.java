package com.example.ex18;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class GenderFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_gender,container,false);
        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = view.findViewById(R.id.name);
                String strName = name.getText().toString();

                TextView text = getActivity().findViewById(R.id.name);
                text.setText(strName);

                RadioButton male=view.findViewById(R.id.male);
                TextView gender=getActivity().findViewById(R.id.gender);
                if(male.isChecked()){
                    gender.setText("남자");
                }else{
                    gender.setText("여자");
                }
            }
        });

        return view;
    }
}
