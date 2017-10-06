package com.example.rasna.androidlabs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    protected final int requestCode=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        Button b1 = (Button) findViewById(R.id.button);
        Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
        // startActivity(intent);
        startActivityForResult(intent, 10);
    }
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
    super.onActivityResult(requestCode,responseCode,data);
        if(requestCode == 10) {
            Log.i(ACTIVITY_NAME, "Retuned to StartActivity.onActivityResult");
        }
            if ( responseCode == Activity.RESULT_OK){
                String messagePassed = data.getStringExtra("Response");
                String text ="ListItemsActivity passed: My information to share" + messagePassed;
                Toast toast = Toast.makeText(StartActivity.this,text,Toast.LENGTH_SHORT);
                toast.show();

            }
        }

    @Override
    public void onResume() {
        super.onResume(); // Always call the superclass method first
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    }
