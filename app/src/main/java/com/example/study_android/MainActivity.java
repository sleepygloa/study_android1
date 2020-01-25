package com.example.study_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1000;

    ImageView imageView;
    TextView textView;
    EditText editText;

    FragmentManager framentManager;
    Button button;

    public static final String BUNDLE_KEY = "bundle_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Lifecycle", "1 : onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragmentOne = new Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("BUNDLE_KEY", 10);
        fragmentOne.setArguments(bundle);


        framentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = framentManager.beginTransaction();
        //fragmentTransaction.add(R.id.container, new FlagmentOne());
        fragmentTransaction.add(R.id.container, fragmentOne);
        fragmentTransaction.commit();
        //확인1
        //확인2
        //확인3
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = framentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new FlagmentTwo());
                fragmentTransaction.commit();
            }
        });



// 계산기 프로젝트
//        textView = findViewById(R.id.textView);
//        textView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        editText = findViewById(R.id.editText);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.d("beforeTextChanged", " s : "+s);
//                Log.d("beforeTextChanged", " start : "+start);
//                Log.d("beforeTextChanged", " count : "+count);
//                Log.d("beforeTextChanged", " after : "+after);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("onTextChanged", " s : "+s);
//                Log.d("onTextChanged", " start : "+start);
//                Log.d("onTextChanged", " before : "+before);
//                Log.d("onTextChanged", " count : "+count);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d("afterTextChanged", " s : "+s);
//            }
//        });

//        Intent comingIntent = getIntent();
//        boolean again = comingIntent.getBooleanExtra("AGAIN", true);
//        Log.d("AGAIN", ""+again);
//
//        //명시적 I....................ntent
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


//        //xml 의 뷰 컴포넌트를 자바로 가져오는 방법
//        imageView = findViewById(R.id.imageView1);
//        textView = findViewById(R.id.textview1);
//
//        //xml의 뷰 컴포넌트를 동적으로 변경하는 방법
//        imageView.setImageResource(R.drawable.mountain_2);
//        textView.setText("안녕하세요");
//
//        //Res 에 정의도니 string을 가져오는 방법
//        String content = getApplicationContext().getResources().getString(R.string.long_text);
//        textView.setText(content);
//
//        //Res에 정의된 string-array 가져오는 방법
//        getApplicationContext().getResources().getStringArray(R.array.string_array);
//        Log.d("string_array", getApplicationContext().getResources().getStringArray(R.array.string_array)[1]);

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
