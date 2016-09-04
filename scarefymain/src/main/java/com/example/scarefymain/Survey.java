package com.example.scarefymain;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Survey extends Activity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Toast toast = Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_LONG);
        toast.show();

    }
}
