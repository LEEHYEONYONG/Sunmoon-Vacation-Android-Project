package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /*implements Button.OnClickListener*/{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText kor=findViewById(R.id.kor);
                EditText eng=findViewById(R.id.eng);
                EditText math=findViewById(R.id.math);

                String strKor=kor.getText().toString();
                String strEng=eng.getText().toString();
                String strMath=math.getText().toString();

                int intKor=Integer.parseInt(strKor);
                int intEng=Integer.parseInt(strEng);
                int intMath=Integer.parseInt(strMath);

                int intTot=intKor+intEng+intMath;
                double dubAvg=(double) intTot/3;

                TextView tot=findViewById(R.id.sum);
                TextView avg=findViewById(R.id.avg);
                tot.setText("총점:"+intTot);
                avg.setText("평균:"+dubAvg);


            }
        });


    }
    /*
    @Override
    public void onClick(View view){

    }
    */

}