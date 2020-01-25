package com.example.study_android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FlagmentTwo extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Lifecycle", "FlagmentTwo : onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle", "FlagmentTwo : onCreate");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_two, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Lifecycle", "FlagmentTwo : onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Lifecycle", "FlagmentTwo : onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Lifecycle", "FlagmentTwo : onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Lifecycle", "FlagmentTwo : onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "FlagmentTwo : onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Lifecycle", "FlagmentTwo : onDetach");
    }
}
