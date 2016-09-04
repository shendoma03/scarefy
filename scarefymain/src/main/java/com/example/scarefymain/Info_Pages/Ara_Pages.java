package com.example.scarefymain.Info_Pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scarefymain.R;
import com.example.scarefymain.stages_all_ara.Ara_1;
import com.example.scarefymain.stages_all_ara.Ara_2;
import com.example.scarefymain.stages_all_ara.Ara_3;

public class Ara_Pages extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ara_pages);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ara1 = new Intent(Ara_Pages.this,Ara_1.class);
                startActivity(ara1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ara2 = new Intent(Ara_Pages.this,Ara_2.class);
                startActivity(ara2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ara3 = new Intent(Ara_Pages.this,Ara_3.class);
                startActivity(ara3);
            }
        });
    }
}

