package com.example.scarefymain.stages_all;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scarefymain.Info_Pages.Kat_Pages;
import com.example.scarefymain.R;

public class Kat_1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kat_1);

        Button _return = (Button)findViewById(R.id.btn_return);
        _return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Kat_1.this, Kat_Pages.class);
                startActivity(go);
                finish();
            }
        });


    }
}
