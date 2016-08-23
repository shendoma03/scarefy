package com.example.scarefymain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.scarefymain.Info_Pages.Kat_Pages;
import com.example.scarefymain.R;

public class Menu_activity extends Activity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity);

        String [] menu_arr={"Katsaridaphobia","Arachnophobia","Fictional Theraphy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu_arr);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mMessageClickedHandler);
    }

    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            Intent to_Kat = new Intent(Menu_activity.this,Kat_Pages.class);
            Intent to_Ara = new Intent(Menu_activity.this,MainActivity.class);
            Intent to_Fic = new Intent(Menu_activity.this,MainActivity.class);
            if (position == 0)startActivity(to_Kat);
            if (position == 1)startActivity(to_Ara);
            if (position == 2)startActivity(to_Fic);
        }
    };



}
