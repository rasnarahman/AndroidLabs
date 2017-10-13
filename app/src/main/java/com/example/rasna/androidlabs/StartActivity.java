package com.example.rasna.androidlabs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "StartActivity";
    protected final int requestCode=10;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        Button button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ChatWindow.class);
                // startActivity(intent);
                startActivityForResult(intent, 10);
            }
        });
    }

    protected void onActivityResult(int requestCode, int responseCode, Intent data){

        super.onActivityResult(requestCode,responseCode,data);

        if(requestCode == 10) {
            Log.i(ACTIVITY_NAME, "Returns to StartActivity.onActivityResult");
        }

        if ( responseCode == Activity.RESULT_OK){
            String messgPassed = data.getStringExtra("Response");
            CharSequence text = "ListItemsActivity Passed:"+messgPassed;
            Toast toast = Toast.makeText(StartActivity.this,text,Toast.LENGTH_LONG);
            toast.show();
            Log.i(ACTIVITY_NAME,messgPassed);
        }
    }

    protected void onResume() {
        super.onResume(); // Always call the superclass method first
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}