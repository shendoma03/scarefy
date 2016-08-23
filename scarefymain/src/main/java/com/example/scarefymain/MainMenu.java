package com.example.scarefymain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button content = (Button)findViewById(R.id.btn1);
        content.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent aboutInt = new Intent(MainMenu.this,MainActivity.class);
                startActivity(aboutInt);
            }
        });

        Button about = (Button)findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent aboutInt = new Intent(MainMenu.this,AboutActivity.class);
                startActivity(aboutInt);
            }
        });



    }
}
