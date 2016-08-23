package com.example.scarefymain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scarefymain.R;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button about = (Button)findViewById(R.id.btn2m);
        about.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent aboutInt = new Intent(AboutActivity.this,MainMenu.class);
                startActivity(aboutInt);
            }
        });
    }
}
