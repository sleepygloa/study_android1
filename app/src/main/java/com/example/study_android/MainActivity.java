package com.example.study_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    protected  void onStart(){
        Log.d("Lifecycle", "onStart");
        super .onStart();
    }
    @Override
    protected  void onResume(){
        Log.d("Lifecycle", "onResume");
        super.onResume();
    }
    @Override
    protected  void onPause(){
        Log.d("Lifecycle", "onPause");
        super.onPause();
    }
    @Override
    protected  void onStop(){
        Log.d("Lifecycle", "onStop");
        super.onStop();
    }
    @Override
    protected  void onDestroy(){
        Log.d("Lifecycle", "onDestroy");
        super.onDestroy();
    }
    @Override
    protected void onRestart(){
        Log.d("Lifecycle", "onRestart");
        super.onRestart();
    }



}
