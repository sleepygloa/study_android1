package com.example.study_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1000;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Lifecycle", "1 : onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml 의 뷰 컴포넌트를 자바로 가져오는 방법
        imageView = findViewById(R.id.imageView1);
        textView = findViewById(R.id.textview1);

        //xml의 뷰 컴포넌트를 동적으로 변경하는 방법
        imageView.setImageResource(R.drawable.mountain_2);
        textView.setText("안녕하세요");

        //Res 에 정의도니 string을 가져오는 방법
        String content = getApplicationContext().getResources().getString(R.string.long_text);
        textView.setText(content);

        //Res에 정의된 string-array 가져오는 방법
        getApplicationContext().getResources().getStringArray(R.array.string_array);
        Log.d("string_array", getApplicationContext().getResources().getStringArray(R.array.string_array)[1]);


//        Intent comingIntent = getIntent();
//        boolean again = comingIntent.getBooleanExtra("AGAIN", true);
//        Log.d("AGAIN", ""+again);
//
//        //명시적 Intent
//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("INTENT_KEY", 5);
//        //startActivity(intent);
//        startActivityForResult(intent, REQUEST_CODE);

        //암시적 Intent
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:google.com"));
//        startActivity(intent);


        //객체 선언후 객체를 다른곳에서 활용할떄
        //Thread 만드는 방법
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//            };
//        };
//        Thread thread = new Thread(runnable);

//        //Thread 만드는 방법 2
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                Log.d("runnable", "1");
////                Toast.makeText(MainActivity.this, "토스트", Toast.LENGTH_LONG).show();
////            }
////        }).start();
////
////
////        //Ui Thread 만드는 법
////        runOnUiThread(new Runnable() {
////            @Override
////            public void run() {
////                Toast.makeText(MainActivity.this, "토스트", Toast.LENGTH_LONG).show();
////            }
////        });

//        Context context = this; //Activity Context
//        //Context context = MainActivity.this;
//
//        Context applicationContext = getApplicationContext(); //Application Context

    }

//  @Override
////  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
////        if(requestCode == REQUEST_CODE){
////            if(resultCode == 200){
////                String result = data.getStringExtra("RESULT");
////                Log.d("onActivityResult", "result : " + result);
////            }else if(resultCode == 300){
////            }
////
////        }
////  }

/*
    @Override
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }
    */

    @Override
    protected  void onStart(){
        Log.d("Lifecycle", "1 : onStart");
        super .onStart();
    }
    @Override
    protected  void onResume(){
        Log.d("Lifecycle", "1 : onResume");
        super.onResume();
    }
    @Override
    protected  void onPause(){
        Log.d("Lifecycle", "1 : onPause");
        super.onPause();
    }
    @Override
    protected  void onStop(){
        Log.d("Lifecycle", "1 : onStop");
        super.onStop();
    }
    @Override
    protected  void onDestroy(){
        Log.d("Lifecycle", "1 : onDestroy");
        super.onDestroy();
    }
    @Override
    protected void onRestart(){
        Log.d("Lifecycle", "1 : onRestart");
        super.onRestart();
    }



}
