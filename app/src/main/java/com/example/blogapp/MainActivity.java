package com.example.blogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler handler = new Handler();
        handler.postDelayed(() -> isFirstTime(),1500);
    }
    private static final String TAG = "isFirstTime";
    private void isFirstTime() {
        // for checking if the app is running for the first time
        //we need to save a value to shared preferences
        SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
        boolean isFirstTime =preferences.getBoolean("isFirstTime",true);
        //default valuetrue
        Log.i(TAG,"what is the value of isFirstTime " + isFirstTime);
        if(isFirstTime){
            //if its true when its first time and we will change it false
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false) ;
            editor.apply();

            //start Onboard activity
            Log.i(TAG, "I have reached the ifFirsttimeLoop");
            startActivity(new Intent(MainActivity.this,OnBoardActivity.class));
            finish();
        }
        else {
            //start Auth Activity
            Log.i(TAG, "I have reached the else in the iffirsttimeloop");
            startActivity(new Intent(MainActivity.this,AuthActivity.class));
            finish();
        }
    }
}