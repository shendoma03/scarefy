package com.example.scarefymain;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scarefymain.stages_all_ara.Ara_1;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainMenu extends AppCompatActivity {

    private static final String TAG = MainMenu.class.getSimpleName();

    private VrPanoramaView panoWidgetView;

    public boolean loadImageSuccessful;

    private Uri fileUri;

    private VrPanoramaView.Options panoOptions = new VrPanoramaView.Options();
    private ImageLoaderTask backgroundImageLoaderTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button content = (Button)findViewById(R.id.btn1);
        content.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent aboutInt = new Intent(MainMenu.this,Menu_activity.class);
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

        Button settings = (Button)findViewById(R.id.btnset);
        settings.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent set = new Intent(MainMenu.this,SettingsActivity.class);
                startActivity(set);
            }
        });

        Button help = (Button)findViewById(R.id.btnhelp);
        help.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent set = new Intent(MainMenu.this,HelpActivity.class);
                startActivity(set);
            }
        });

        Button survey = (Button)findViewById(R.id.btnsurvey);
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set = new Intent(MainMenu.this,Survey.class);
                startActivity(set);
            }
        });
        panoWidgetView = (VrPanoramaView) findViewById(R.id.pano_view);
        panoWidgetView.setEventListener(new ActivityEventListener());
        handleIntent(getIntent());


    }
    @Override
    protected void onNewIntent(Intent intent) {
        Log.i(TAG, this.hashCode() + ".onNewIntent()");
        setIntent(intent);
        handleIntent(intent);
    }
    private void handleIntent(Intent intent) {
        // Determine if the Intent contains a file to load.
        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            Log.i(TAG, "ACTION_VIEW Intent recieved");
            fileUri = intent.getData();
            if (fileUri == null) {
                Log.w(TAG, "No data uri specified. Use \"-d /path/filename\".");
            } else {
                Log.i(TAG, "Using file " + fileUri.toString());
            }
            panoOptions.inputType = intent.getIntExtra("inputType", VrPanoramaView.Options.TYPE_MONO);
            Log.i(TAG, "Options.inputType = " + panoOptions.inputType);
        } else {
            Log.i(TAG, "Intent is not ACTION_VIEW. Using default pano image.");
            fileUri = null;
            panoOptions.inputType = VrPanoramaView.Options.TYPE_MONO;
        }
        if (backgroundImageLoaderTask != null) {
            // Cancel any task from a previous intent sent to this activity.
            backgroundImageLoaderTask.cancel(true);
        }
        backgroundImageLoaderTask = new ImageLoaderTask();
        backgroundImageLoaderTask.execute(Pair.create(fileUri, panoOptions));
    }
    @Override
    protected void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        panoWidgetView.resumeRendering();
    }
    @Override
    protected void onDestroy() {
        panoWidgetView.shutdown();
        if (backgroundImageLoaderTask != null) {
            backgroundImageLoaderTask.cancel(true);
        }
        super.onDestroy();
    }
    class ImageLoaderTask extends AsyncTask<Pair<Uri, VrPanoramaView.Options>, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Pair<Uri, VrPanoramaView.Options>... fileInformation) {
            VrPanoramaView.Options panoOptions = null;  // It's safe to use null VrPanoramaView.Options.
            InputStream istr = null;
            if (fileInformation == null || fileInformation.length < 1
                    || fileInformation[0] == null || fileInformation[0].first == null) {
                AssetManager assetManager = getAssets();
                try {
                    istr = assetManager.open("welcome.jpg");
                    panoOptions = new VrPanoramaView.Options();
                    panoOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
                } catch (IOException e) {
                    Log.e(TAG, "Could not decode default bitmap: " + e);
                    return false;
                }
            } else {
                try {
                    istr = new FileInputStream(new File(fileInformation[0].first.getPath()));
                    panoOptions = fileInformation[0].second;
                } catch (IOException e) {
                    Log.e(TAG, "Could not load file: " + e);
                    return false;
                }
            }panoWidgetView.loadImageFromBitmap(BitmapFactory.decodeStream(istr), panoOptions);
            try {
                istr.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close input stream: " + e);
            }

            return true;
        }
    }
    private class ActivityEventListener extends VrPanoramaEventListener {

        @Override
        public void onLoadSuccess() {
            loadImageSuccessful = true;
        }

        @Override
        public void onLoadError(String errorMessage) {
            loadImageSuccessful = false;
            Toast.makeText(
                    MainMenu.this, "Error loading pano: " + errorMessage, Toast.LENGTH_LONG)
                    .show();
            Log.e(TAG, "Error loading pano: " + errorMessage);
        }
    }

}
