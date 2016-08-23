package com.example.scarefymain.Info_Pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scarefymain.MainActivity;
import com.example.scarefymain.R;
import com.example.scarefymain.stages_all.Kat_1;
import com.example.scarefymain.stages_all.Kat_2;

public class Kat_Pages extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kat__pages);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent aboutInt = new Intent(Kat_Pages.this,Kat_1.class);
                startActivity(aboutInt);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent aboutInt = new Intent(Kat_Pages.this,Kat_2.class);
                startActivity(aboutInt);
            }
        });



    }
}
