package com.example.scarefymain;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        RunMe RunSplash = new RunMe();
        Thread t = new Thread(RunSplash);
        t.start();


    }
    class RunMe implements Runnable{
        @Override
        public void run() {
            SystemClock.sleep(3000);
            Intent intent = new Intent(SplashScreen.this,Menu_activity.class);
            startActivity(intent);
            finish();
        }
    }

}
