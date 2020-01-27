package com.example.study_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1000;

    ImageView imageView;
    TextView textView;
    EditText editText;

    FragmentManager framentManager;
    Button button;

    public static final String BUNDLE_KEY = "bundle_key";

    ImageView imageViewOne;
    ImageView imageViewTwo;
    ImageView imageViewThree;
    ImageView imageViewFour;
    Context context;

    ArrayList<String> stringList;
    LayoutInflater layoutInflater;
    LinearLayout container;

    ArrayList<String> list;

    RecyclerView recyclerView;
    ArrayList<String> itemList;

    ViewPager viewPager;
    TabLayout tabLayout;

    TextView textview1;
    MyService myService;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Lifecycle", "1 : onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor())
                .build();

        Retrofit retrofit =
                new Retrofit
                    .Builder()
                    .baseUrl("http://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        myService = retrofit.create(MyService.class);

        textView = findViewById(R.id.textView1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestUserRepo();
            }
        });
        textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postUser();
            }
        });

        Log.d("test", "PRE !");
        BackgroundTask backgroundTask = new BackgroundTask();
        backgroundTask.execute();

        Log.d("test", "POST !");



        String sharedPreferencesName = "SAVE_1";
        String sharedPreferencesKey = "KEY";

        //Sharedpreferences 에 데이터 저장하는 방법
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferencesName, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(sharedPreferencesKey, "안녕하세요");
        editor.commit();

        //Sharedpreferences 에 데이터 불러오는 방법
        String value = sharedPreferences.getString(sharedPreferencesKey, "");
        Log.d("test", "value : " + value);

        //Sharedpreferences 에 데이터 삭제하는 방법
        editor.remove(sharedPreferencesKey);
        editor.clear();
        editor.commit();

        //Sharedpreferences 에 데이터 불러오는 방법
        value = sharedPreferences.getString(sharedPreferencesKey, "실패");
        Log.d("test", "value : " + value);

        Person person = new Person("홍길동", 20);
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        Log.d("test", "value : " + personJson);
        String sharedPreferencePersonKey = "person_key";
        editor.putString(sharedPreferencePersonKey, personJson);
        editor.commit();

        String personString = sharedPreferences.getString(sharedPreferencePersonKey, "실패_2");
        Person loadedPerson = gson.fromJson(personString, Person.class);

        Log.d("test", "person age : "+ loadedPerson.age);

//        viewPager = findViewById(R.id.view_pager);
//        tabLayout = findViewById(R.id.tab_layout);
//
//
//        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
//        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
//        tabLayout.addTab(tabLayout.newTab().setText("THREE"));
//
//        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
//        viewPager.setAdapter(pagerAdapter);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//
//        });
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        recyclerView = findViewById(R.id.recycler_view);
//        itemList = new ArrayList<String>();
//        itemList.add("가");
//        itemList.add("나");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//        itemList.add("가");
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new MyAdapter(itemList));
//    }
//        class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
//
//            private ArrayList<String> itemList;
//            public MyAdapter(ArrayList<String> itemList){
//                this.itemList = itemList;
//            }
//
//
//            @NonNull
//            @Override
//            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//                View view = layoutInflater.inflate(R.layout.item_view, parent, false);
//                return new ViewHolder(view);
//            }
//
//            @Override
//            public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
//                viewHolder.textView.setText(itemList.get(position));
//            }
//
//            @Override
//            public int getItemCount() {
//                return itemList.size();
//            }
//
//            class ViewHolder extends RecyclerView.ViewHolder{
//                TextView textView;
//
//
//                public ViewHolder(@NonNull View itemView){
//                    super(itemView);
//                    textView = itemView.findViewById(R.id.item_text);
//                }
//            }


//        ListView  listView = findViewById(R.id.list_view);
//
//        list = new ArrayList<String>();
//        list.add("가");
//        list.add("나");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//        list.add("가");
//
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        View header = layoutInflater.inflate(R.layout.header_view, null, false);
//        View footer = layoutInflater.inflate(R.layout.footer_view, null, false);
//
//        listView.addHeaderView(header);
//        listView.addFooterView(footer);
//
//
//
//
//        final MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
//        header.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                list.set(1, "가");
//                Log.d("test", "list change");
//                myAdapter.notifyDataSetChanged();
//            }
//        });
//        listView.setAdapter(myAdapter);


//        stringList = new ArrayList<String>();
//        stringList.add("가");
//        stringList.add("나");
//        stringList.add("다");
//        stringList.add("라");
//        stringList.add("마");
//        stringList.add("바");
//        stringList.add("사");
//
//        container = findViewById(R.id.container);
//
//        layoutInflater = LayoutInflater.from(MainActivity.this);
//
//        for(int i = 0; i < stringList.size(); i++){
//            View view = layoutInflater.inflate(R.layout.list_item_view, null, false);
//            TextView itemText = view.findViewById(R.id.item_view_text);
//            itemText.setText(stringList.get(i));
//
//            view.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Log.d("test", "CLICK");
//                }
//            });
//
//            container.addView(view);
//        }


//        context = this;
//        imageViewOne = findViewById(R.id.image_one);
//        imageViewTwo = findViewById(R.id.image_two);
//        imageViewThree = findViewById(R.id.image_three);
//        imageViewFour = findViewById(R.id.image_four);
//
//        //웹 이미지 넣는 방법
//        Glide.with(MainActivity.this)
//            .load("http://post.phinf.naver.net/MjAxNzEyMDhfNDIg/MDAxNTEyNzIxNDUyMzc4.Vo9sfxImkLvkGHRC9XdDL24GKu47He19K-2CN-tfpmcg.UB3tvdcrSGLB1FUP5Njgx724jG1G7l_Ph56xZBY52XIg.JPEG/IcFL8dbgYvPz4T_yqWEoDWEIdGUw.jpg")
//            .into(imageViewOne);
//
//        //option을 사용하는 방법
//        RequestOptions cropOption = new RequestOptions().centerCrop();
//        Glide.with(context)
//            .load("http://post.phinf.naver.net/MjAxNzEyMDhfNDIg/MDAxNTEyNzIxNDUyMzc4.Vo9sfxImkLvkGHRC9XdDL24GKu47He19K-2CN-tfpmcg.UB3tvdcrSGLB1FUP5Njgx724jG1G7l_Ph56xZBY52XIg.JPEG/IcFL8dbgYvPz4T_yqWEoDWEIdGUw.jpg")
//            .apply(cropOption)
//            .into(imageViewTwo);
//
//        //option을 사용하는 방법
//        RequestOptions circleCrop = new RequestOptions().circleCrop();
//        Glide.with(context)
//                .load("http://post.phinf.naver.net/MjAxNzEyMDhfNDIg/MDAxNTEyNzIxNDUyMzc4.Vo9sfxImkLvkGHRC9XdDL24GKu47He19K-2CN-tfpmcg.UB3tvdcrSGLB1FUP5Njgx724jG1G7l_Ph56xZBY52XIg.JPEG/IcFL8dbgYvPz4T_yqWEoDWEIdGUw.jpg")
//                .apply(circleCrop)
//                .into(imageViewThree);
//
//        //로컬 이미지 불러오는 방법
//        Glide.with(context).load(R.drawable.ic_launcher_background).into(imageViewFour);

//        Fragment fragmentOne = new Fragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("BUNDLE_KEY", 10);
//        fragmentOne.setArguments(bundle);
//
//
//        framentManager = getSupportFragmentManager();
//        final FragmentTransaction fragmentTransaction = framentManager.beginTransaction();
//        //fragmentTransaction.add(R.id.container, new FlagmentOne());
//        fragmentTransaction.add(R.id.container, fragmentOne);
//        fragmentTransaction.commit();
//
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction = framentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, new FlagmentTwo());
//                fragmentTransaction.commit();
//            }
//        });



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

    public void postUser(){
        Call<JsonArray> postUser = myService.postUser("sleepygloa", 20);
        postUser.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }

    public void requestUserRepo(){
        Call<JsonArray> requestUserRepo = myService.getUseRepositories("sleepygloa");
        requestUserRepo.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });

    }

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer>{

        @Override
        protected void onPreExecute() {
            Log.d("test", "onPreExcute");
            super.onPreExecute();

        }
        @Override
        protected Integer doInBackground(Integer... integers) {
            int result = 0;
            for (int i = 0 ; i< 100; i++){
                result++;
                if(i%10 == 0){
                    publishProgress(i);
                }
            }
            return result;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("test", "Progess :" + values[0] +"%" );
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("test", "Result : " + integer);
            super.onPostExecute(integer);
        }
    }

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




//
//    class MyAdapter extends BaseAdapter{
//        private ViewHolder viewHolder;
//        private LayoutInflater inflater;
//        private ArrayList<String> itemList;
//
//        public MyAdapter(Context context, ArrayList<String> itemList){
//            this.itemList = itemList;
//            this.inflater = LayoutInflater.from(context);
//        }
//
//        @Override
//        public int getCount() {
//            return itemList.size();
//        }
//
//        @Override
//        public String getItem(int position) {
//            return itemList.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view = convertView;
//            if(view == null){
//                viewHolder = new ViewHolder();
//                view = inflater.inflate(R.layout.list_item_view, null);
//                viewHolder.textView = view.findViewById(R.id.item_view_text);
//                view.setTag(viewHolder);
//
//            }else{
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            viewHolder.textView.setText(getItem(position));
//
//
//            return view;
//        }
//
//        class ViewHolder {
//            public TextView textView = null;
//        }
//    }

}
