package com.example.scarefymain.Info_Pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scarefymain.R;
import com.example.scarefymain.stages_all_kat.Kat_1;
import com.example.scarefymain.stages_all_kat.Kat_2;
import com.example.scarefymain.stages_all_kat.Kat_3;

public class Kat_Pages extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kat_pages);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent kat_1 = new Intent(Kat_Pages.this,Kat_1.class);
                startActivity(kat_1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent kat_2 = new Intent(Kat_Pages.this,Kat_2.class);
                startActivity(kat_2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kat_3 = new Intent(Kat_Pages.this,Kat_3.class);
                startActivity(kat_3);
            }
        });



    }
}
