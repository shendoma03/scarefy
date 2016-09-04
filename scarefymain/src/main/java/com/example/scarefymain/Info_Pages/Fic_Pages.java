package com.example.scarefymain.Info_Pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scarefymain.R;
import com.example.scarefymain.stages_all_fic.Fic_1;
import com.example.scarefymain.stages_all_fic.Fic_2;
import com.example.scarefymain.stages_all_fic.Fic_3;


public class Fic_Pages extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fic_pages);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fic1 = new Intent(Fic_Pages.this,Fic_1.class);
                startActivity(fic1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fic2 = new Intent(Fic_Pages.this,Fic_2.class);
                startActivity(fic2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fic3 = new Intent(Fic_Pages.this,Fic_3.class);
                startActivity(fic3);
            }
        });
    }
}
