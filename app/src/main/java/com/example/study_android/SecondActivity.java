package com.example.study_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Lifecycle", "2 : onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //명시적 Intent
//        Intent intent = getIntent();
//        int data = intent.getIntExtra("INTENT_KEY", 0);
//        Log.d("INTENT_KEY", ""+data);

//        Intent intent = new Intent();
//        intent.putExtra("RESULT", "성공");
//        setResult(200, intent);
//        finish();

//        //명시적 Intent
//        Intent intent = new Intent(this, ThirdActivity.class);
//        intent.putExtra("INTENT_KEY", 5);
//        startActivity(intent);


    }


    @Override
    protected  void onStart(){
        Log.d("Lifecycle", "2 : oonStart");
        super .onStart();
    }
    @Override
    protected  void onResume(){
        Log.d("Lifecycle", "2 : oonResume");
        super.onResume();
    }
    @Override
    protected  void onPause(){
        Log.d("Lifecycle", "2 : oonPause");
        super.onPause();
    }
    @Override
    protected  void onStop(){
        Log.d("Lifecycle", "2 : oonStop");
        super.onStop();
    }
    @Override
    protected  void onDestroy(){
        Log.d("Lifecycle", "2 : oonDestroy");
        super.onDestroy();
    }
    @Override
    protected void onRestart(){
        Log.d("Lifecycle", "2 : onRestart");
        super.onRestart();
    }

}
