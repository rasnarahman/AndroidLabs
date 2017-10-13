package com.example.rasna.androidlabs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.content.SharedPreferences;                                       //.design.widget.FloatingActionButton;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends Activity {
    final String ACTIVITY_NAME = "StartActivity";
    protected String DefaultEmail = "email@domain.com";
            Button button3;
    protected String defaultEmail="email@domain.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SharedPreferences email = getSharedPreferences(" AnyFileName", MODE_PRIVATE);
        final EditText editT = (EditText) findViewById(R.id.TE);
        String address = email.getString("DefaultEmail", defaultEmail);
        editT.setText(address);

        button3 = (Button) findViewById(R.id.button2);
        email.getString("DefaultEmail", "email@domain.com");
        button3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String inputEmail = editT.getEditableText().toString();
                SharedPreferences.Editor writer = email.edit();
                writer.putString("DefaultEmail", inputEmail);
                writer.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);

            }
        });
        email.getString("DefaultEmail","jain0022@algonquinlive.com");
    }


    @Override
            public void onStart() {
                super.onStart();
                Log.i(ACTIVITY_NAME, "In onStart()");

            }
            @Override
            public void onResume() {
                super.onResume();
                Log.i(ACTIVITY_NAME, "In onResume()");
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